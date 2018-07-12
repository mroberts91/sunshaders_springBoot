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
        for (int x=0; x < 10; x++){
            Appointment appt = new Appointment();
            appt.setFirstname("Tom");
            appt.setLastname("Smith");
            appt.setAppointemntDate("2018-07-12");
            appt.setAppointmentTime("08:00:00");
            appointments.add(appt);
        }
        for (int i=0; i < 5; i++){
            Appointment appt = new Appointment();
            appt.setFirstname("Mike");
            appt.setLastname("Rob");
            appt.setAppointemntDate("2018-08-11");
            appt.setAppointmentTime("08:00:00");
            appointments.add(appt);
        }

        for (int i=0; i < 5; i++){
            Appointment appt = new Appointment();
            appt.setFirstname("Ashley");
            appt.setLastname("Miller");
            appt.setAppointemntDate("2017-06-15");
            appt.setAppointmentTime("08:00:00");
            appointments.add(appt);
        }

        for (int i=0; i < 5; i++){
            Appointment appt = new Appointment();
            appt.setFirstname("Matthew");
            appt.setLastname("Cole");
            appt.setAppointemntDate("2018-07-09");
            appt.setAppointmentTime("08:00:00");
            appointments.add(appt);
        }
        for (int i=0; i < 100; i++){
            Appointment appt = new Appointment();
            appt.setFirstname("Test");
            appt.setLastname("Test");
            appt.setAppointemntDate("2018-12-11");
            appt.setAppointmentTime("11:00:00");
            appointments.add(appt);
        }
//        for(Appointment appt : appointmentRepository.findAll()){
//            appointments.add(appt);
//        }
        // Sortt the List by date and then by time
        appointments.sort(Comparator.comparing(Appointment::getAppointemntDate)
                .thenComparing(Appointment::getAppointmentTime));
//        //appointments.sort(Comparator.comparing(Appointment::getAppointmentTime));
        return appointments;


    }
}
