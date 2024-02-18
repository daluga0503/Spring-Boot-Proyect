package com.example.incidentmanager.Incidents.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.incidentmanager.Incidents.domain.IncidentDto;
import com.example.incidentmanager.Incidents.domain.IncidentEntity;
import com.example.incidentmanager.Incidents.domain.IncidentRepository;
import com.example.incidentmanager.User.domain.UserEntity;
import com.example.incidentmanager.User.domain.UserRepository;

@Service
public class IncidentServiceImp implements IncidentService {

    private IncidentRepository repository;
    private UserRepository userRepository;

    public IncidentServiceImp(IncidentRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public IncidentEntity createIncident(IncidentDto incident) {
        //int userId = incident.getUserId();
        int userId = 302; // tener cuidado
        UserEntity user = this.userRepository.findById(userId).orElseThrow() ;
        IncidentEntity newIncident = new IncidentEntity();
        BeanUtils.copyProperties(incident, newIncident, "USER_ID");
        newIncident.setUser(user);
        return this.repository.save(newIncident);
    }

    @Override
    public Iterable<IncidentEntity> getAll() {
        return this.repository.findAll();
    }

    @Override
    public IncidentEntity updateIncident(int id, IncidentEntity incident) {
        IncidentEntity oldIncident = this.repository.findById(id).orElseThrow();

        oldIncident.setId(incident.getId());
        oldIncident.setTitle(incident.getTitle());
        oldIncident.setImage(incident.getImage());
        oldIncident.setImageType(incident.getImageType());
        return this.repository.save(oldIncident);
    }

    @Override
    public void deleteIncident(int id) {
        this.repository.deleteById(id);
    }
    
}
