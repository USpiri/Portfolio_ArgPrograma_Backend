package com.portfolio.backenduspiri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String birth_date;
    private String age;
    private String phone;
    private String email;
    private String lit_about;
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
