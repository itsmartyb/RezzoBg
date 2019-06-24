package com.rezzobg.controllers;

import com.rezzobg.dto.OfferDetailsDTO;
import com.rezzobg.dto.OfferDtoForList;
import com.rezzobg.exceptions.InvalidOfferException;
import com.rezzobg.models.Offer;
import com.rezzobg.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public OfferDetailsDTO getOfferDetails(@PathVariable(required = false) Long offerId) throws InvalidOfferException {
        return offerService.getOfferDetails(offerId);
    }
}
