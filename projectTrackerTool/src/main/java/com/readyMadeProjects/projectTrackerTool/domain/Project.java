package com.readyMadeProjects.projectTrackerTool.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String projectName;
    private String projectIdentifier;
    private String description;
    private Date start_date;
    private Date end_date;

    private Date created_At;
    private Date updated_At;


    //to SAVE FRESH DATE EVERY TIME DATA PERSITANCE HAPPENS
    @PrePersist
    protected void onCreate()
    {
        this.created_At= new Date();
    }


    @PreUpdate
    protected void onUpdate()
    {
        this.updated_At= new Date();
    }


}
