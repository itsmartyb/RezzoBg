package com.rezzobg.services;

import com.rezzobg.dto.AddressDTO;
import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.dto.RestaurantDTO;
import com.rezzobg.exceptions.InvalidRestaurantException;
import com.rezzobg.models.*;
import com.rezzobg.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenRepository kitchenRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private ExtraService extraService;

    @Autowired
    private CharacteristicRepository characteristicRepository;

    @Autowired
    private PlaceRepository placeRepository;


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

    public void addRestaurant(RestaurantDTO restaurantDTO) {
        Address address = manageAddress(restaurantDTO);
        List<Extra> extras = restaurantDTO.getExtras().stream().map(extraName -> new Extra(extraName)).collect(Collectors.toList());
        for(Extra extra: extras) {
            if(!extraService.isInDatabase(extra)) {
                extraService.saveExtra(extra);
            }
        }

        List<String> photoURL = restaurantDTO.getUrlPhotos();
        List<Photo> photos = photoURL.stream().map(url -> new Photo(url)).collect(Collectors.toList());
        Set<Characteristic> characteristics;
        List<String> kitchenNames = restaurantDTO.getKitchenNames();
        characteristics = kitchenNames.stream().map(kitchenName -> new Characteristic(null, kitchenName)).collect(Collectors.toSet());
        for(Characteristic c : characteristics) {

        }
        Restaurant restaurant = new Restaurant(restaurantDTO.getName(), restaurantDTO.getStartWorkingDay(), restaurantDTO.getEndWorkingDay(),
                restaurantDTO.getMidAmount(), 0.0, restaurantDTO.getDescription(), restaurantDTO.getPlaces(), address);
        restaurant.setPhotos(photos);
        // characteristicRepository.save(characteristics);
        //photoService.savePhotos(photos);
        // extraService.saveExtras(extras);
        restaurant.setExtras(extras);
        placeRepository.save(restaurant);
        restaurantRepository.save(restaurant);
    }
}
