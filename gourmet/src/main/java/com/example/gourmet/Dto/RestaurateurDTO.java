package com.example.gourmet.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurateurDTO extends AppUserDTO {


    private String offreSpeciale;
    private Set<RestaurantDTO> restaurants;
}
