package com.doranco.appli1.user;


//import com.doranco.appli1.auth2.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class User {
    @Id
    @Column(length = 30)
    private String username;
    private String prenom;
    private String email;
    private String phone;
    private String password;
    private String role;


    /*@ManyToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Authority> authorities;*/

    public User(String username, String prenom, String email, String phone) {
        this.username = username;
        this.prenom=prenom;
        this.email = email;
        this.phone = phone;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
