package com.rezzobg.controllers;

import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PlaceController {
    @Autowired
    private PlaceService restaurantService;

    @GetMapping("/restaurants")
    public List<PlaceDtoForList> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/clubs")
    public List<PlaceDtoForList> getAllClubs() {
        return restaurantService.getAllClubs();
    }
}
