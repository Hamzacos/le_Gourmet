package com.example.gourmet.Service.Implementation;

import com.example.gourmet.Dto.RestaurantDTO;
import com.example.gourmet.Entity.Restaurant;
import com.example.gourmet.Repository.RestaurantRepository;
import com.example.gourmet.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDTO> findByPays(String pays) {
        List<Restaurant> restaurants = restaurantRepository.findRestaurantByPays(pays);
        return restaurants.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private RestaurantDTO convertToDTO(Restaurant restaurant) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setAdresse(restaurant.getAdresse());
        dto.setVille(restaurant.getVille());
        dto.setPays(restaurant.getPays());
        dto.setTelephone(restaurant.getTelephone());
        dto.setNoteMoyenne(restaurant.getNote_moyenne());
        dto.setCuisine(restaurant.getCuisine());
        dto.setImage(restaurant.getImage());
        dto.setManger(restaurant.getManager());
        //dto.setPlats(restaurant.getPlats());
        //dto.setReservations(restaurant.getReservations());
        return dto;
    }

}
