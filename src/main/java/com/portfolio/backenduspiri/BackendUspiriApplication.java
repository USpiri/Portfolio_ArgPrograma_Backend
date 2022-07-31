package com.portfolio.backenduspiri;

import com.portfolio.backenduspiri.model.Person;
import com.portfolio.backenduspiri.service_interface.IPersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendUspiriApplication {

    public static void main(String[] args) {
            SpringApplication.run(BackendUspiriApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner defaultData(IPersonService svc) {
        return args -> { 
            if (svc.getPeople().isEmpty()) { 
                svc.createPerson(new Person(1l, "", "", "", "", "", "", "", "", ""));
            }
        };
    }

}
