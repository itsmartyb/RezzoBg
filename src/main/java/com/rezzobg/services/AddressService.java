package com.rezzobg.services;

import com.rezzobg.dto.AddressDTO;
import com.rezzobg.dto.SignUpDTO;
import com.rezzobg.models.Address;
import com.rezzobg.models.City;
import com.rezzobg.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityService cityService;

    public Address getAndSaveAddress(AddressDTO addressDTO) {
       return this.addressRepository.save(new Address(null, addressDTO.getStreet(), addressDTO.getArea(),
                cityService.getAndSaveCity(addressDTO.getCity()), addressDTO.getCountry()));
    }

    public CityService getCityService() {
        return this.cityService;
    }
}
