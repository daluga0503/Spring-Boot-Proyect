package com.example.incidentmanager.Incidents.domain;

public class IncidentDto {
    private int id;
    private String title;
    private String userId;


    
    public IncidentDto(int id, String title, String userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
