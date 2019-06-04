package com.rezzobg.controllers;

import com.rezzobg.models.Address;
import com.rezzobg.models.Club;
import com.rezzobg.models.Place;
import com.rezzobg.models.Restaurant;
import com.rezzobg.repositories.AddressRepository;
import com.rezzobg.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;


@RestController
public class PlaceController {

//    @Autowired
//    private AddressRepository repository;
//
//    @Autowired
//    private PlaceRepository placeRepository;

//    @PostMapping("/restaurants")
//    public void addRestaurant() {
//        Address a = new Address();
//        a = repository.findById(1l).get();
//        Place restaurant = new Restaurant("restaurant", new Time(10000l), new Time(500000), 3.4, "Super", 15, a, "super kuhnq" );
//        placeRepository.save(restaurant);
//    }
//
//    @PostMapping("/clubs")
//    public void addClub() {
//        Address a = new Address();
//        a = repository.findById(2l).get();
//        Place restaurant = new Club("megami", new Time(700000000), new Time(500543200), 4.4, "Duperr", 15, a, "da jivee vladi markov" );
//        placeRepository.save(restaurant);
//    }


}
