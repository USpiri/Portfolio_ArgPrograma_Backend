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
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size( max = 45 , message = "[Experience.company] - Not accurate size")
    private String company;
    
    @NotNull
    @Size( max = 45 , message = "[Experience.job] - Not accurate size")
    private String job;
    
    @NotNull
    private boolean is_actual;
    
    @NotNull
    @Size( max = 10 , message = "[Experience.start_date] - Not accurate size")
    private String start_sate;
    
    @Size( max = 10 , message = "[Experience.end_date] - Not accurate size")
    private String end_date;
    
    @NotNull
    @Size( max = 200 , message = "[Experience.img_url] - Not accurate size")
    private String img_url;
    
    @Size( max = 200 , message = "[Experience.link] - Not accurate size")
    private String link;
    
    @NotNull
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
