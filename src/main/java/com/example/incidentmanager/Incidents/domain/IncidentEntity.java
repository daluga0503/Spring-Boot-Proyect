package com.example.incidentmanager.Incidents.domain;


import com.example.incidentmanager.User.domain.UserEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "incident")
public class IncidentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String title;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    byte[] image;
    String imageType;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;

    public IncidentEntity(){

    }


    
    public IncidentEntity(int id, String title, byte[] image, String imageType, UserEntity user) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.imageType = imageType;
        this.user = user;
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
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
}
