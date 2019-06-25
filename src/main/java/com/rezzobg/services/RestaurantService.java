package com.rezzobg.services;

import com.rezzobg.dto.AddressDTO;
import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.dto.RestaurantDTO;
import com.rezzobg.exceptions.InvalidRestaurantException;
import com.rezzobg.models.*;
import com.rezzobg.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenService kitchenService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private ExtraService extraService;

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

    private Address manageAddress(RestaurantDTO restaurantDTO) {
        return addressService.getAndSaveAddress(new AddressDTO(restaurantDTO.getStreet(),
                restaurantDTO.getArea(), restaurantDTO.getCity(), restaurantDTO.getCountry()));
    }

    private List<Photo> getPhotos(RestaurantDTO restaurantDTO, Place place) {
        return restaurantDTO.getUrlPhotos().stream().map(url -> new Photo(url, place)).collect(Collectors.toList());
    }

    private Set<Extra> getAndSaveExtras(RestaurantDTO restaurantDTO) {
        Set<Extra> extras = new HashSet<>();
        for(String extra: restaurantDTO.getExtras()) {
            if(!this.extraService.isInDatabase(extra)) {
                extras.add(this.extraService.saveExtra(new Extra(extra)));
            } else {
                extras.add(this.extraService.findExtra(extra));
            }
        }
         return extras;
    }

    private Set<Kitchen> getAndSaveCharacteristics(RestaurantDTO restaurantDTO) {
        Set<Kitchen> kitchens = new HashSet<>();
        for(String name: restaurantDTO.getKitchenNames()) {
            if(!this.characteristicService.isInDatabase(name)) {
                kitchens.add(this.kitchenService.saveKitchen(new Kitchen(name)));
            } else {
                kitchens.add((Kitchen)this.characteristicService.findCharacteristic(name));
            }
        }
        return kitchens;
    }

    public void addRestaurant(RestaurantDTO restaurantDTO) {
        Address address = manageAddress(restaurantDTO);
        Restaurant restaurant = new Restaurant(restaurantDTO.getName(), restaurantDTO.getStartWorkingDay(), restaurantDTO.getEndWorkingDay(),
                restaurantDTO.getMidAmount(), 0.0, restaurantDTO.getDescription(), restaurantDTO.getPlaces(), address);

        Set<Kitchen> kitchens = getAndSaveCharacteristics(restaurantDTO);
        Set<Extra> extras = getAndSaveExtras(restaurantDTO);

        restaurant.setKitchens(kitchens);
        restaurant.setExtras(extras);
        System.out.println(restaurant.getExtras());

        Restaurant r = this.restaurantRepository.save(restaurant);
        List<Photo> photos = getPhotos(restaurantDTO, r);





        this.photoService.saveAll(photos);
    }
}
