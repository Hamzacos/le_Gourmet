package com.example.gourmet.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatDTO {
    private Long id;
    private String description;
    private double prix;
    private String image;
    private RestaurantDTO restaurant;
    private Set<FeedbackDTO> feedbacks;

}
