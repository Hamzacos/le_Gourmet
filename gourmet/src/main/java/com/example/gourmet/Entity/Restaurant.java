package com.example.gourmet.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adresse;
    private String ville;
    private String pays;
    private String telephone;
    private double note_moyenne;
    private String cuisine;
    private String image;

    @ManyToOne
    private Restaurateur restaurateur;

    @OneToMany(mappedBy = "restaurant")
    private Set<Plat> plats = new HashSet<>();

    @OneToMany(mappedBy = "restaurant")
    private Set<Reservation> reservations = new HashSet<>();

}
