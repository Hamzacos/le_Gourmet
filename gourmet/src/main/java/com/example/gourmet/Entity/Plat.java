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
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double prix;
    private String image;

    @ManyToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "plat")
    private Set<Feedback> feedbacks = new HashSet<>();

}
