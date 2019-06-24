package com.rezzobg.services;

import com.rezzobg.dto.OfferDetailsDTO;
import com.rezzobg.dto.OfferDtoForList;
import com.rezzobg.exceptions.InvalidOfferException;
import com.rezzobg.models.Offer;
import com.rezzobg.models.Place;
import com.rezzobg.models.Proposal;
import com.rezzobg.repositories.OfferRepository;
import com.rezzobg.repositories.PlaceRepository;
import com.rezzobg.repositories.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private PlaceRepository placeRepository;

    public List<OfferDtoForList> getAllOffers() {
        List<Offer> offers  = offerRepository.findAll();
        return offers.stream().map(offer -> new OfferDtoForList(offer.getTitle(), offer.getPictureUrl(), offer.getPrice()))
                .collect(Collectors.toList());
    }

    public OfferDetailsDTO getOfferDetails(Long id) throws InvalidOfferException {
        Optional<Offer> offerFromDB = offerRepository.findById(id);
        Offer offer = null;
        Proposal proposal = null;
        try {
            offer  = offerFromDB.get();
        } catch(Exception e) {
            throw new InvalidOfferException();
        }
        Optional<Place> place = placeRepository.findById(id);
        return new OfferDetailsDTO(offer.getId(), offer.getPictureUrl(), offer.getDescription(),
                offer.getTitle(), offer.getDate(), offer.getPrice(), place.get());
    }
}
