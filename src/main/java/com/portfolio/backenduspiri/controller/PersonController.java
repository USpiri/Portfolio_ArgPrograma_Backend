package com.portfolio.backenduspiri.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@CrossOrigin( origins = "http://localhost:4200" )
public class PersonController {
    
    @GetMapping
    public String getPerson(){
        return "Conectado al Servidor";
    }
    
}
