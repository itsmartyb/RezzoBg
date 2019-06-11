package com.rezzobg.services;

import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.models.Restaurant;
import com.rezzobg.repositories.KitchenRepository;
import com.rezzobg.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenRepository kitchenRepository;

    public List<PlaceDtoForList> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<String> kitchenNames = kitchenRepository.findAll().stream()
                .map(kitchen -> kitchen.getName()).collect(Collectors.toList());

        return restaurants.stream().map(restaurant -> new PlaceDtoForList(restaurant.getName(), restaurant.getPhotos().get(0).getUrl(),
                restaurant.getMidAmount(), restaurant.getAddress().getArea(), restaurant.getRating(), kitchenNames))
                .collect(Collectors.toList());
    }
}
