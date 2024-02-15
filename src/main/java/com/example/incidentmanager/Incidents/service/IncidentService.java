package com.example.incidentmanager.Incidents.service;

import com.example.incidentmanager.Incidents.domain.IncidentEntity;

public interface IncidentService {

    public IncidentEntity createIncident(IncidentEntity incident);

    public Iterable<IncidentEntity> getAll();

    public IncidentEntity updateIncident(int id, IncidentEntity incident);

    public void deleteIncident(int id);
}
