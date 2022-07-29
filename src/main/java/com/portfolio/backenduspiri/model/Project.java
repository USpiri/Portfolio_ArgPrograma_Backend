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
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size( max = 45 , message = "[Project.name] - Not accurate size")
    private String name;
    
    @NotNull
    @Size( max = 100 , message = "[Project.description] - Not accurate size")
    private String description;
    
    @NotNull
    @Size( max = 200 , message = "[Project.img_url] - Not accurate size")
    private String img_url;
    
    @Size( max = 200 , message = "[Project.link] - Not accurate size")
    private String link;
    
    @NotNull
    private boolean enabled_link;

    public Project() {
    }

    public Project(Long id, String name, String description, String img_url, String link, boolean enabled_link) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img_url = img_url;
        this.link = link;
        this.enabled_link = enabled_link;
    }
    
}
