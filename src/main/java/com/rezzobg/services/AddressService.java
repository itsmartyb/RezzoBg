package com.rezzobg.services;

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

    public Address getAndSaveAddress(SignUpDTO signUpDTO) throws Exception {
        Address address = new Address(null, signUpDTO.getStreet(), signUpDTO.getArea(),
                cityService.getCity(signUpDTO), signUpDTO.getCountry());
        this.addressRepository.save(address);
        return address;
    }

}
