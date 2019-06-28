package com.rezzobg.services;

import com.rezzobg.dto.AddressDTO;
import com.rezzobg.dto.PlaceDTO;
import com.rezzobg.models.Address;
import com.rezzobg.models.Extra;
import com.rezzobg.models.Photo;
import com.rezzobg.models.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class PlaceService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private ExtraService extraService;


    public Address manageAddress(PlaceDTO placeDTO) {
        return addressService.getAndSaveAddress(new AddressDTO(placeDTO.getStreet(),
                placeDTO.getArea(), placeDTO.getCity(), placeDTO.getCountry()));
    }

    public List<Photo> getPhotos(PlaceDTO placeDTO, Place place) {
        return this.photoService.saveAll(placeDTO.getUrlPhotos().stream().map(url -> new Photo(url, place)).collect(Collectors.toList()));
    }

    public List<Extra> getAndSaveExtras(PlaceDTO placeDTO) {
        List<Extra> extras = new LinkedList<>();
        for (String extra : placeDTO.getExtras()) {
            if (!this.extraService.isInDatabase(extra)) {
                extras.add(this.extraService.saveExtra(new Extra(extra)));
            } else {
                extras.add(this.extraService.findExtra(extra));
            }
        }
        return extras;
    }
}