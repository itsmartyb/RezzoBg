package com.rezzobg.services;

import com.rezzobg.dto.PlaceDTO;
import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.exceptions.InvalidRestaurantException;
import com.rezzobg.models.*;
import com.rezzobg.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantService extends PlaceService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenService kitchenService;

    @Autowired
    private KitchenRepository kitchenRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CharacteristicService characteristicService;


    private List<PlaceDtoForList> collectRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream().map(restaurant -> new PlaceDtoForList(restaurant.getName(), restaurant.getPhotos().get(0).getUrl(),
                restaurant.getMidAmount(), restaurant.getAddress().getArea(), restaurant.getRating(),
                kitchenRepository.findByRestaurantsId(restaurant.getId()).stream()
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

    private Set<Kitchen> getAndSaveCharacteristics(PlaceDTO placeDTO) {
        Set<Kitchen> kitchens = new HashSet<>();
        for(String name: placeDTO.getCharacteristicNames()) {
            if(!this.characteristicService.isInDatabase(name)) {
                kitchens.add(this.kitchenService.saveKitchen(new Kitchen(name)));
            } else {
                kitchens.add((Kitchen)this.characteristicService.findCharacteristic(name));
            }
        }
        return kitchens;
    }

    public void addRestaurant(PlaceDTO placeDTO) {
        Address address = manageAddress(placeDTO);
        Restaurant restaurant = new Restaurant(placeDTO.getName(), placeDTO.getStartWorkingDay(), placeDTO.getEndWorkingDay(),
                placeDTO.getMidAmount(), 0.0, placeDTO.getDescription(), placeDTO.getPlaces(), address);
        restaurant.setKitchens(getAndSaveCharacteristics(placeDTO));
        restaurant.setExtras(getAndSaveExtras(placeDTO));
        Restaurant r = this.restaurantRepository.save(restaurant);
        List<Photo> photos = getPhotos(placeDTO, r);
    }
}
