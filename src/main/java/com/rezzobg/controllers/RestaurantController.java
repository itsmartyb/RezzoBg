package com.rezzobg.controllers;

import com.rezzobg.dto.PlaceDTO;
import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.exceptions.InvalidRestaurantException;
import com.rezzobg.models.Restaurant;
import com.rezzobg.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<PlaceDtoForList> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{cityId}/restaurants")
    public List<PlaceDtoForList> getAllRestaurantsByCity(@PathVariable(required = false) Long cityId) {
        return restaurantService.getAllRestaurantsByCity(cityId);
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantDetails(@PathVariable(required = false) Long restaurantId) throws InvalidRestaurantException {
        return restaurantService.getRestaurantDetails(restaurantId);
    }

    @PostMapping("/restaurants")
    public void addRestaurant(@Valid @RequestBody PlaceDTO placeDTO) throws InvalidRestaurantException {
        this.restaurantService.addRestaurant(placeDTO);
    }
}
