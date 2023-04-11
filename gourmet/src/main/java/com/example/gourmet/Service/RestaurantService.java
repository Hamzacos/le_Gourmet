package com.example.gourmet.Service;

import com.example.gourmet.Dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {

     List<RestaurantDTO> findByPays(String pays);
}
