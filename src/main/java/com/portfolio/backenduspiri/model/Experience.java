package com.portfolio.backenduspiri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String company;
    private String job;
    private boolean is_actual;
    private String start_sate;
    private String end_date;
    private String img_url;
    private String link;
    private boolean enabled_link;

    public Experience() {
    }

    public Experience(Long id, String company, String job, boolean is_actual, String start_sate, String end_date, String img_url, String link, boolean enabled_link) {
        this.id = id;
        this.company = company;
        this.job = job;
        this.is_actual = is_actual;
        this.start_sate = start_sate;
        this.end_date = end_date;
        this.img_url = img_url;
        this.link = link;
        this.enabled_link = enabled_link;
    }
    
}
