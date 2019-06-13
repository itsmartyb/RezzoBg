package com.rezzobg.services;

import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.exceptions.InvalidRestaurantException;
import com.rezzobg.models.Restaurant;
import com.rezzobg.repositories.KitchenRepository;
import com.rezzobg.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenRepository kitchenRepository;

    private List<PlaceDtoForList> collectRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream().map(restaurant -> new PlaceDtoForList(restaurant.getName(), restaurant.getPhotos().get(0).getUrl(),
                restaurant.getMidAmount(), restaurant.getAddress().getArea(), restaurant.getRating(),
                kitchenRepository.findByRestaurants(restaurant.getId()).stream()
                        .map(kitchen -> kitchen.getName()).collect(Collectors.toList()))).collect(Collectors.toList());

    }

    public List<PlaceDtoForList> getAllRestaurantsByCity(Long id) {
        List<Restaurant> restaurants = restaurantRepository.findByAddressCityId(id);
        return collectRestaurants(restaurants);
    }

    public List<PlaceDtoForList> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return collectRestaurants(restaurants);
    }

    public Restaurant getRestaurantDetails(Long id) throws InvalidRestaurantException {
        Optional<Restaurant> restaurantFromDB = restaurantRepository.findById(id);
        Restaurant restaurant = null;
        try {
            restaurant = restaurantFromDB.get();
        } catch(Exception e) {
            throw new InvalidRestaurantException();
        }
        return restaurant;
    }
}
