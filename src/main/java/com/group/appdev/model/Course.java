package com.group.appdev.model;

import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users uploadedBy;

    // Constructors
    public Course() {}

    public Course(String title, String image, Users uploadedBy) {
        this.title = title;
        this.image = image;
        this.uploadedBy = uploadedBy;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Users getUploadedBy() {
        return uploadedBy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUploadedBy(Users uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
}
