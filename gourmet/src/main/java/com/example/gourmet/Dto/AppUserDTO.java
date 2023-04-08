package com.example.gourmet.Dto;

import com.example.gourmet.Entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUserDTO {

    private Long id_user;
    private String nomComplet;
    private String username;
    private String password;
    private String email;
    private Collection<String> userRoles;
    private Set<Restaurant> restaurants;
}
