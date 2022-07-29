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
public class Image {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size( max = 200 , message = "[Image.header] - Not accurate size")
    private String header;
    
    @NotNull
    @Size( max = 200 , message = "[Image.about] - Not accurate size")
    private String about;

    public Image() {
    }

    public Image(Long id, String header, String about) {
        this.id = id;
        this.header = header;
        this.about = about;
    }
    
}
