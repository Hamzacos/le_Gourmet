package com.example.gourmet.Dto;

import com.example.gourmet.Entity.appUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long id;
    private LocalDate date;
    private int nombrePersonnes;
    private RestaurantDTO restaurant;
    private appUser client;

}
