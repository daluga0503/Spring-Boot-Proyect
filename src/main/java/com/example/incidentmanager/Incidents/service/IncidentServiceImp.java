package com.example.incidentmanager.Incidents.service;

import org.springframework.stereotype.Service;

import com.example.incidentmanager.Incidents.domain.IncidentEntity;
import com.example.incidentmanager.Incidents.domain.IncidentRepository;

@Service
public class IncidentServiceImp implements IncidentService {

    private IncidentRepository repository;

    public IncidentServiceImp(IncidentRepository repository){
        this.repository = repository;
    }

    @Override
    public IncidentEntity createIncident(IncidentEntity incident) {
        return this.repository.save(incident);
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
