package com.example.incidentmanager.Incidents.domain;

import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<IncidentEntity,Integer>{
    
}
