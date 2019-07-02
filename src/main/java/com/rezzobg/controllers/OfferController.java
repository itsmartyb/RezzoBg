package com.rezzobg.controllers;

import com.rezzobg.dto.OfferDTO;
import com.rezzobg.dto.OfferDetailsDTO;
import com.rezzobg.dto.OfferDtoForList;
import com.rezzobg.dto.PlaceDTO;
import com.rezzobg.exceptions.InvalidOfferException;
import com.rezzobg.exceptions.InvalidPlaceException;
import com.rezzobg.exceptions.InvalidUserException;
import com.rezzobg.exceptions.UserIsLoggedInException;
import com.rezzobg.models.Offer;
import com.rezzobg.services.OfferService;
import com.rezzobg.services.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public Long addOffer(@Valid @RequestBody OfferDTO offerDTO, HttpServletRequest request) throws InvalidPlaceException,
            InvalidUserException, UserIsLoggedInException  {
        if (UserStory.isUserLogged(request)) {
            if (UserStory.isAdminLogged(request)) {
                return offerService.addOffer(offerDTO);
            } else {
                throw new InvalidUserException("User does not have rights for this operation!");
            }
        } else {
            throw new UserIsLoggedInException("User is not logged in");
        }
    }
}
