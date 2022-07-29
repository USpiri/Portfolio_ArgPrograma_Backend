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
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size( max = 100 , message = "[Education.where] - Not accurate size")
    private String where;
    
    @NotNull
    @Size( max = 45 , message = "[Education.degree] - Not accurate size")
    private String degree;
    
    @NotNull
    private boolean is_actual;
    
    @NotNull
    @Size( max = 10 , message = "[Education.start_date] - Not accurate size")
    private String start_date;
    
    @Size( max = 10 , message = "[Education.end_date] - Not accurate size")
    private String end_date;
    
    @NotNull
    @Size( max = 200 , message = "[Education.img_url] - Not accurate size")
    private String img_url;
    
    @Size( max = 100 , message = "[Education.link] - Not accurate size")
    private String link;
    
    @NotNull
    private boolean enabled_link;

    public Education() {
    }

    public Education(Long id, String where, String degree, boolean is_actual, String start_date, String end_date, String img_url, String link, boolean enabled_link) {
        this.id = id;
        this.where = where;
        this.degree = degree;
        this.is_actual = is_actual;
        this.start_date = start_date;
        this.end_date = end_date;
        this.img_url = img_url;
        this.link = link;
        this.enabled_link = enabled_link;
    }
    
}
