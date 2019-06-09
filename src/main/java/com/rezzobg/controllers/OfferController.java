package com.rezzobg.controllers;

import com.rezzobg.dto.OfferDtoForList;
import com.rezzobg.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
