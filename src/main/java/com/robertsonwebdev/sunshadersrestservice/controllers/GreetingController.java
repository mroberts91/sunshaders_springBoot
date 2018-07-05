package com.robertsonwebdev.sunshadersrestservice.controllers;

import com.robertsonwebdev.persistence.ApptRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Guest")String name, Model model){
//        ApptRepository repo = new ApptRepository();
//        String queryRessult = repo.getQuery();
//        repo.createNewAppointment("Tom", "Jackson", "2018-07-03", "21:00");
//        model.addAttribute("rs", queryRessult);
        model.addAttribute("name", name);
        return "greeting";
    }
}
