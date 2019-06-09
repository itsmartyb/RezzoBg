package com.rezzobg.services;

import com.rezzobg.dto.EventDtoForList;
import com.rezzobg.dto.OfferDtoForList;
import com.rezzobg.dto.ProposalDtoForList;
import com.rezzobg.models.Offer;
import com.rezzobg.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<OfferDtoForList> getAllOffers() {
        List<Offer> offers  = offerRepository.findAll();
        return offers.stream().map(offer -> new OfferDtoForList(offer.getTitle(), offer.getPictureUrl(), offer.getPrice()))
                .collect(Collectors.toList());
    }
}
