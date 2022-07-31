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
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size( max = 45 , message = "[User.username] - Not accurate size")
    private String username;
    
    @NotNull
    @Size( max = 45 , message = "[User.password] - Not accurate size")
    private String password;

    public User() {
    }

    public User(Long id, String username, String password, String level, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
}
