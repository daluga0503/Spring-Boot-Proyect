package com.example.incidentmanager.Incidents.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.server.ResponseStatusException;

import com.example.incidentmanager.Incidents.core.IncidentAlreadyExistException;
import com.example.incidentmanager.Incidents.domain.IncidentEntity;
import com.example.incidentmanager.Incidents.service.IncidentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.NoSuchElementException;

import java.io.InputStream;




@RestController
public class IncidentController {

    public IncidentController(IncidentService service){
        this.service = service;
    }
    
    private IncidentService service;

    @GetMapping("api/incidents")
    public Iterable<IncidentEntity> getAllIncidents() {
        return this.service.getAll();
    }

    @PostMapping(path = "api/incidents", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public IncidentEntity createIncident(@RequestPart("incident") IncidentEntity incident,
                                        @RequestParam("image") MultipartFile image) {
        
        try {
            InputStream imageInputStream = image.getInputStream();
            byte[] imageBytes = imageInputStream.readAllBytes();
            String contentType = image.getContentType();
            incident.setImage(imageBytes);
            incident.setImageType(contentType);
            return  this.service.createIncident(incident);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("api/incidents/{id}")
    public void deleteIncident(@PathVariable int id){
        this.service.deleteIncident(id);
    }
    
    @PutMapping("api/incidents/{id}")
    public IncidentEntity putMethodName(@PathVariable int id, @RequestBody IncidentEntity incident) {
        try {
            return this.service.updateIncident(id, incident);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El incidente no existe");
        }
    }
    
}
