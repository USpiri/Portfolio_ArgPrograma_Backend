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
public class SocialMedia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size( max = 100 , message = "[SocialMedia.facebook] - Not accurate size")
    private String facebook;
    
    @NotNull
    @Size( max = 100 , message = "[SocialMedia.twitter] - Not accurate size")
    private String twitter;
    
    @NotNull
    @Size( max = 100 , message = "[SocialMedia.instagram] - Not accurate size")
    private String instagram;
    
    @NotNull
    @Size( max = 100 , message = "[SocialMedia.github] - Not accurate size")
    private String github;
    
    @NotNull
    @Size( max = 100 , message = "[SocialMedia.cv] - Not accurate size")
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
