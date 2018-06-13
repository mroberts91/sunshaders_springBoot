package com.robertsonwebdev.sunshadersrestservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RequestController {

    @RequestMapping(value = "/", method = GET)
    public List<Response> response(){
        List<Response> responseList = new ArrayList<>();
        responseList.add(new Response(0, "Hello World"));
        responseList.add(new Response(1, "Hello More Worlds"));
        responseList.add(new Response(2, "Hello No One"));
        return responseList;
    }
}
