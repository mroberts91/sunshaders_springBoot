package com.robertsonwebdev.sunshadersrestservice.controllers;

import com.robertsonwebdev.domain.Appointment;
import com.robertsonwebdev.domain.Response;
import com.robertsonwebdev.persistence.ApptRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RequestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ArrayList<Appointment> response(){
        try {
            ApptRepository repo = new ApptRepository();
            repo.appointmentQuery();
            return repo.getAppointments();
        } catch (Exception ex){
            ArrayList<Appointment> list = new ArrayList<>();
            list.add(new Appointment("SQL", "Exception", "occured", ex.getMessage()));
            return list;
        }
    }
}
