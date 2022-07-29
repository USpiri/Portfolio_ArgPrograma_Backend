package com.portfolio.backenduspiri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size( max = 45 , message = "[Skill.name] - Not accurate size")
    private String name;
    
    @NotNull
    @Size( max = 10 , message = "[Skill.percentage] - Not accurate size")
    private String percentage;
    
    @NotNull
    @Size( max = 45 , message = "[Skill.icon] - Not accurate size")
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
