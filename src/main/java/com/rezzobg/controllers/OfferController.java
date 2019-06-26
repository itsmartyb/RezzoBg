package com.rezzobg.controllers;

import com.rezzobg.dto.OfferDTO;
import com.rezzobg.dto.OfferDetailsDTO;
import com.rezzobg.dto.OfferDtoForList;
import com.rezzobg.dto.PlaceDTO;
import com.rezzobg.exceptions.InvalidOfferException;
import com.rezzobg.exceptions.InvalidPlaceException;
import com.rezzobg.models.Offer;
import com.rezzobg.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public List<OfferDtoForList> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/offers/{offerId}")
    public OfferDetailsDTO getOfferDetails(@PathVariable(required = false) Long offerId)
            throws InvalidOfferException, InvalidPlaceException{
        return offerService.getOfferDetails(offerId);
    }

    @PostMapping("/offers")
    public Long addOffer(@Valid @RequestBody OfferDTO offerDTO) throws InvalidPlaceException {
        return offerService.addOffer(offerDTO);
    }
}
