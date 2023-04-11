package com.example.gourmet.Conroller;


import com.example.gourmet.Dto.RestaurantDTO;
import com.example.gourmet.Entity.Restaurant;
import com.example.gourmet.Repository.RestaurantRepository;
import com.example.gourmet.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/restaurants/{pays}")
    public List<RestaurantDTO> searchRestaurantsByPays(@PathVariable("pays") String pays) {
        return restaurantService.findByPays(pays);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant,
                                                       @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        String uploadDir = "images/";

        // Crée le dossier "images" s'il n'existe pas déjà
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdir();
        }

        // Stocke l'image dans le dossier "images"
        Path path = Paths.get(uploadDir + fileName);
        Files.write(path, imageFile.getBytes());

        // Met à jour le chemin d'accès à l'image dans l'entité Restaurant
        restaurant.setImage(uploadDir + fileName);

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return ResponseEntity.ok(savedRestaurant);
    }
}
