package com.portfolio.backenduspiri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String img_url;
    private String link;
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
