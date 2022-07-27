package com.portfolio.backenduspiri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class SocialMedia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String facebook;
    private String twitter;
    private String instagram;
    private String github;
    private String cv;

    public SocialMedia() {
    }

    public SocialMedia(Long id, String facebook, String twitter, String instagram, String github, String cv) {
        this.id = id;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.github = github;
        this.cv = cv;
    }
    
}
