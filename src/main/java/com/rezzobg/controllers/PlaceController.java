package com.rezzobg.controllers;

import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.models.Restaurant;
import com.rezzobg.services.ClubService;
import com.rezzobg.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PlaceController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private ClubService clubService;

    @GetMapping("/restaurants")
    public List<PlaceDtoForList> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/clubs")
    public List<PlaceDtoForList> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/clubs/{cityId}")
    public List<PlaceDtoForList> getAllClubsByCity(@PathVariable(required = false) Long cityId) {
        return clubService.getAllClubsByCity(cityId);
    }
}
