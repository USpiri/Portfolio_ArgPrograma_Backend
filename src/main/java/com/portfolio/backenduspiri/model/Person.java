package com.portfolio.backenduspiri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size( max = 45 , message = "[Persona.name] - Not accurate size")
    private String name;
    
    @NotNull
    @Size( max = 45 , message = "[Persona.surname] - Not accurate size")
    private String surname;
    
    @NotNull
    @Size( max = 45 , message = "[Persona.address] - Not accurate size")
    private String address;
    
    @NotNull
    @Size( max = 10 , message = "[Persona.birth_date] - Not accurate size")
    private String birth_date;
    
    @NotNull
    @Size( max = 10 , message = "[Persona.age] - Not accurate size")
    private String age;
    
    @NotNull
    @Size( max = 25 , message = "[Persona.phone] - Not accurate size")
    private String phone;
    
    @NotNull
    @Size( max = 45 , message = "[Persona.email] - Not accurate size")
    @Email
    private String email;
    
    @NotNull
    @Size( max = 80 , message = "[Persona.lit_about] - Not accurate size")
    private String lit_about;
    
    @NotNull
    @Size( max = 200 , message = "[Persona.about] - Not accurate size")
    private String about;

    public Person() {
    }

    public Person(Long id, String name, String surname, String address, String birth_date, String age, String phone, String email, String lit_about, String about) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.birth_date = birth_date;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.lit_about = lit_about;
        this.about = about;
    }
    
}
