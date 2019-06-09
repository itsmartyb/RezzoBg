package com.rezzobg.services;

import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.models.*;
import com.rezzobg.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenRepository kitchenRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private GenreRepository genreRepository;


    public List<PlaceDtoForList> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<String> kitchenNames = kitchenRepository.findAll().stream()
                .map(kitchen -> kitchen.getName()).collect(Collectors.toList());

        return restaurants.stream().map(restaurant -> new PlaceDtoForList(restaurant.getName(), restaurant.getPhotos().get(0).getUrl(),
                restaurant.getMidAmount(), restaurant.getAddress().getArea(), restaurant.getRating(), kitchenNames))
                .collect(Collectors.toList());
    }

    public List<PlaceDtoForList> getAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        List<String> genreNames = genreRepository.findAll().stream()
                .map(genre -> genre.getName()).collect(Collectors.toList());

        return clubs.stream().map(club -> new PlaceDtoForList(club.getName(), club.getPhotos().get(0).getUrl(),
                club.getMidAmount(), club.getAddress().getArea(), club.getRating(), genreNames)).collect(Collectors.toList());
    }
}
