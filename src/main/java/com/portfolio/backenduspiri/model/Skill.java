package com.portfolio.backenduspiri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String percentage;
    private String icon;

    public Skill() {
    }

    public Skill(Long id, String name, String percentage, String icon) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.icon = icon;
    }
    
}
