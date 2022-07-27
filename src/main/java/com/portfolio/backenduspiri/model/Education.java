package com.portfolio.backenduspiri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String where;
    private String degree;
    private boolean is_actual;
    private String start_date;
    private String end_date;
    private String img_url;
    private String link;
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
