package com.robertsonwebdev.domain;

import java.util.Date;

public class Appointment {
    private String firstname;
    private String lastname;
    private String scheduled;


    // Constuctor
    public Appointment(String firstname, String lastname, String scheduled){
        this.firstname = firstname;
        this.lastname = lastname;
        this.scheduled = scheduled;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }
}
