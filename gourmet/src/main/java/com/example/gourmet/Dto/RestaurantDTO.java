package com.example.gourmet.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    private Long id;
    private String name;
    private String adresse;
    private String ville;
    private String pays;
    private String telephone;
    private double noteMoyenne;
    private String cuisine;
    private String image;
    private RestaurateurDTO restaurateur;
    private Set<PlatDTO> plats;
    private Set<ReservationDTO> reservations;

}
