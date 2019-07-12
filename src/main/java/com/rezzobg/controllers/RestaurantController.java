package com.rezzobg.controllers;

import com.rezzobg.dto.PlaceDTO;
import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.exceptions.InvalidRestaurantException;
import com.rezzobg.exceptions.InvalidUserException;
import com.rezzobg.exceptions.UserIsLoggedInException;
import com.rezzobg.models.Restaurant;
import com.rezzobg.services.RestaurantService;
import com.rezzobg.services.UserService;
import com.rezzobg.services.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public void addRestaurant(@Valid @RequestBody PlaceDTO placeDTO, HttpServletRequest request) throws InvalidRestaurantException,
            InvalidUserException, UserIsLoggedInException {
        if (UserStory.isUserLogged(request)) {
            if (UserStory.isAdminLogged(request)) {
                this.restaurantService.addRestaurant(placeDTO);
            } else {
                throw new InvalidUserException("User does not have rights for this operation!");
            }
        } else {
            throw new UserIsLoggedInException("There is no such user!");
        }
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable Long restaurantId, HttpServletRequest request) throws
            InvalidUserException, InvalidRestaurantException, UserIsLoggedInException {
        if (UserStory.isUserLogged(request)) {
            if (UserStory.isAdminLogged(request)) {
                this.restaurantService.deleteRestaurant(restaurantId);
            } else {
                throw new InvalidUserException("User does not have rights for this operation!");
            }
        } else {
            throw new UserIsLoggedInException("There is no such user!");
        }
    }
}
