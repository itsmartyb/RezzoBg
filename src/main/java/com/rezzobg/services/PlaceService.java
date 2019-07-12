package com.rezzobg.services;

import com.rezzobg.dto.AddressDTO;
import com.rezzobg.dto.PlaceDTO;
import com.rezzobg.models.*;
import com.rezzobg.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ProposalRepository proposalRepository;


    public Address manageAddress(PlaceDTO placeDTO) {
        return addressService.getAndSaveAddress(new AddressDTO(placeDTO.getStreet(),
                placeDTO.getArea(), placeDTO.getCity(), placeDTO.getCountry()));
    }

    public List<Photo> getAndSavePhotos(PlaceDTO placeDTO, Place place) {
        return this.photoService.saveAll(placeDTO.getUrlPhotos().stream().map(url -> new Photo(url, place)).collect(Collectors.toList()));
    }

    public static double calculatePlaceRating(Place place) {
        double rating = 0.0;
        if(place.getComments().size() == 0) {
            return rating;
        }
        for(Comment comment: place.getComments()) {
            rating += comment.getRating();
        }
        return rating/(place.getComments().size());
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

    @Transactional
    public void deletePlaceRelationsFromDB(Place place) {
        this.commentRepository.removeByPlaceId(place.getId());
        this.addressRepository.removeById(place.getAddress().getId());
        this.photoRepository.removeByPlaceId(place.getId());
        this.offerRepository.removeByPlaceId(place.getId());
        this.eventRepository.removeByPlaceId(place.getId());
    }
}
