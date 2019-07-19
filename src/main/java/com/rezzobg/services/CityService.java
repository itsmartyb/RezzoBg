package com.rezzobg.services;
import com.rezzobg.models.City;
import com.rezzobg.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City getAndSaveCity(String cityName) {
        City city = cityRepository.findByName(cityName);
        if(city == null) {
            city = cityRepository.save(new City(1L, cityName));
        }
        return city;
    }
}
