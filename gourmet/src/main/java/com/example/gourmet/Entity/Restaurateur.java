package com.example.gourmet.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurateur extends appUser{

    private String offre_speciale;

    @OneToMany(mappedBy = "restaurateur")
    private Set<Restaurant> restaurants = new HashSet<>();
}
