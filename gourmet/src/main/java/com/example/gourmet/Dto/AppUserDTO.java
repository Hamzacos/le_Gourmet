package com.example.gourmet.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUserDTO {

    private Long idUser;
    private String nomComplet;
    private String email;
    private Collection<String> userRoles;
}
