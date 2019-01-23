package com.pccoer.jobfair.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobApplicant {
    
    @Id
    private Long id;
    private String firstName;
    private String jobRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    @Override
    public String toString() {
        return "JobApplicant{" + "id=" + id + ", firstName=" + firstName + ", jobRole=" + jobRole + '}';
    }
    
    
}
