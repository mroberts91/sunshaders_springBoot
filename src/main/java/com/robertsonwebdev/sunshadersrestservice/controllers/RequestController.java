package com.robertsonwebdev.sunshadersrestservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response response(){
        return new Response(0, "First JSON Response");
    }
}
