package com.robertsonwebdev.sunshadersrestservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentController {
    @GetMapping(path = "/admin")
    public String goHome(){
        return "index";
    }
}
