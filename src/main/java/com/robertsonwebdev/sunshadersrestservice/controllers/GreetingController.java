package com.robertsonwebdev.sunshadersrestservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class GreetingController {

    @RequestMapping(value = "/greet", method = GET)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Guest")
                           String name,
                           Model model){
        model.addAttribute(name);
        return "greeting";

    }
}
