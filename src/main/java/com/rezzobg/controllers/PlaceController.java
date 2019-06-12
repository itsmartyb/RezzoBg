package com.rezzobg.controllers;

import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.exceptions.InvalidClubException;
import com.rezzobg.exceptions.InvalidRestaurantException;
import com.rezzobg.models.Club;
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

    @GetMapping("/{cityId}/clubs")
    public List<PlaceDtoForList> getAllClubsByCity(@PathVariable(required = false) Long cityId) {
        return clubService.getAllClubsByCity(cityId);
    }

    @GetMapping("/{cityId}/restaurants")
    public List<PlaceDtoForList> getAllRestaurantsByCity(@PathVariable(required = false) Long cityId) {
        return restaurantService.getAllRestaurantsByCity(cityId);
    }

    @GetMapping("/clubs/{clubId}")
    public Club getClubDetails(@PathVariable(required = false) Long clubId) throws InvalidClubException {
        return clubService.getClubDetails(clubId);
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantDetails(@PathVariable(required = false) Long restaurantId) throws InvalidRestaurantException {
        return restaurantService.getRestaurantDetails(restaurantId);
    }
}
