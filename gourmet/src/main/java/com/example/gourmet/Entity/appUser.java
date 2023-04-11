package com.example.gourmet.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class appUser {

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    private String nomComplet;
    private String username;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<appRole> userRoles = new ArrayList<>();*/
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    private String fullName;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
//    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<appRole> userRoles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    private Set<Restaurant> restaurants = new HashSet<>();

    public void addRole(appRole role){
        this.getUserRoles().add(role);
    }
}
