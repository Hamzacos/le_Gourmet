package com.example.gourmet.Repository;

import com.example.gourmet.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    List<Restaurant> findRestaurantByPays(String pays);
}
