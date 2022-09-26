package com.example.demo;

public class Coursemodel {
    private String courseName;
    private String courseDuration;
    private String courseTracks;
    private String id;


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseTracks() {
        return courseTracks;
    }

    public void setCourseTracks(String courseTracks) {
        this.courseTracks = courseTracks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;
    }

    public Coursemodel(String ID, String courseName, String courseDuration, String courseTracks) {
        this.id=ID;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseTracks = courseTracks;
    }
}
