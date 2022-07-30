package com.portfolio.backenduspiri.controller;

import com.portfolio.backenduspiri.model.Person;
import com.portfolio.backenduspiri.service_interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@CrossOrigin( origins = "http://localhost:4200" )
public class PersonController {
    
    @Autowired
    private IPersonService personService;
    
    @GetMapping
    @ResponseBody
    public List<Person> getPeople(){
        System.out.println("LISTA ===========================");
        return personService.getPeople();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public Person getPerson( @PathVariable Long id ){
        System.out.println("MOSTRANDO =======================");
        System.out.println(personService.getPerson(id).getName());
        System.out.println("=================================");
        return personService.getPerson( id );
    }
    
    @PostMapping
    public void savePerson( @RequestBody Person per ){
        personService.createPerson(per);
    }
    
}
