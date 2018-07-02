package com.robertsonwebdev.domain;

import java.util.Date;

public class Appointment {
    private String firstname;
    private String lastname;
    private String apptDate;
    private String apptTime;
    private String created;


    // Constuctor
    public Appointment(String conFirstname, String conLastname, String conDate, String conTime, String conCreated){
        firstname = conFirstname;
        lastname = conLastname;
        apptDate = conDate;
        apptTime = conTime;
        created = conCreated;
    }

    public Appointment(String conFirstname, String conLastname, String conDate, String conTime){
        firstname = conFirstname;
        lastname = conLastname;
        apptDate = conDate;
        apptTime = conTime;
        created = createTimestamp();
    }

    private String createTimestamp() {
        Long epoch = new Date().getTime();
        Date date = new Date(epoch);
        return date.toString();
    }

    // Getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getApptDate() {
        return apptDate;
    }

    public String getApptTime() {
        return apptTime;
    }

    public String getCreated() {
        return created;
    }
}
