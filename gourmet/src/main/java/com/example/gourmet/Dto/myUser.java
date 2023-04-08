package com.example.gourmet.Dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class myUser extends User {


    private int id;
    private String nomComplet;


    public myUser (int id, String username, String password, Collection<? extends GrantedAuthority> authorities,
                   String fullName) {
        super(username, password, authorities);
        this.id = id;
        this.nomComplet = nomComplet;
    }


    public int getId() {
        return id;
    }

    public String nomComplet() {
        return nomComplet;
    }
}
