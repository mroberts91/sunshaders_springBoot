package com.robertsonwebdev.sunshadersrestservice.controllers;

import com.robertsonwebdev.domain.Appointment;
import com.robertsonwebdev.persistence.ApptRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {

    @GetMapping("/appointment")
    public Appointment addNewAppt(){
        return new Appointment("Please send", "As Post", "Resquest");
    }
    @PostMapping("/appointment")
    public ResponseEntity addNewAppointment(
        @RequestBody Appointment appointment){
        try {
            ApptRepository repo = new ApptRepository();
            System.out.println(appointment.getFirstname() + " " + appointment.getLastname() + " " + appointment.getScheduled());
            //repo.createNewAppointment(appointment);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (Exception ex){
            return ResponseEntity.ok(HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
