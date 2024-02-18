package com.example.incidentmanager.Incidents.domain;

public class IncidentDto {
    private int id;
    private String title;
    private byte[] image;
    private String imageType;
    private int userId;


    
    public IncidentDto(int id, String title, byte[] image, String imageType, int userId) {
        this.id = id;
        this.title = title;
        this.image = image;
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
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public String getImageType() {
        return imageType;
    }
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
    
}
