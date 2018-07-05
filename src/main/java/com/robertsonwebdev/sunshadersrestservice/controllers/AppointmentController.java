package com.robertsonwebdev.sunshadersrestservice.controllers;

import com.robertsonwebdev.domain.Appointment;
import com.robertsonwebdev.persistence.ApptRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {

    @PostMapping("/appointment")
    public ResponseEntity addNewAppointment(
        @RequestBody Appointment appointment){
        try {
            ApptRepository repo = new ApptRepository();
            repo.createNewAppointment(appointment);
            return ResponseEntity.ok().body(200);
        } catch (Exception ex){
            return ResponseEntity.unprocessableEntity().body(400);
        }

    }
}
