package com.rezzobg.services;

import com.rezzobg.dto.SignUpDTO;
import com.rezzobg.models.City;
import com.rezzobg.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City getCity(SignUpDTO signUpDTO) {
        City city = cityRepository.findByName(signUpDTO.getCity());
        if(city == null) {
            city = new City(null, signUpDTO.getCity());
            cityRepository.save(city);
        }
        return city;
    }
}
