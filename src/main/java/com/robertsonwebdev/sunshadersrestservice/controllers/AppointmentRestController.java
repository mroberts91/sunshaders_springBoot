package com.robertsonwebdev.sunshadersrestservice.controllers;

import com.robertsonwebdev.sunshadersrestservice.Appointment;
import com.robertsonwebdev.sunshadersrestservice.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path = "/services")
public class AppointmentRestController {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentRestController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping(path="/add")
    public @ResponseBody String addNewAppointment(
            @RequestParam String firstname, @RequestParam String lastname,
            @RequestParam String appointmentDate, @RequestParam String appointmentTime
    ){
        try {
            Appointment newAppoitnment = new Appointment();
            newAppoitnment.setFirstname(firstname);
            newAppoitnment.setLastname(lastname);
            newAppoitnment.setAppointemntDate(appointmentDate);
            newAppoitnment.setAppointmentTime(appointmentTime);
            System.out.println(newAppoitnment.getAppointemntDate());
            System.out.println(newAppoitnment.getAppointmentTime());
            appointmentRepository.save(newAppoitnment);

            return "Appointment was added succesfully";

        } catch (Exception ex){
            return ex.getMessage();
        }
    }

    @GetMapping(path="/all")
    public @ResponseBody List<Appointment> getAllAppointments(){
        List<Appointment> appointments = new ArrayList<>();
        for(Appointment appt : appointmentRepository.findAll()){
            appointments.add(appt);
        }
        // Sortt the List by date and then by time
        appointments.sort(Comparator.comparing(Appointment::getAppointemntDate)
                .thenComparing(Appointment::getAppointmentTime));
        //appointments.sort(Comparator.comparing(Appointment::getAppointmentTime));
        return appointments;


    }
}
