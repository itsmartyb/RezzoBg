package com.rezzobg.controllers;

import com.rezzobg.dto.PlaceDTO;
import com.rezzobg.dto.PlaceDtoForList;
import com.rezzobg.exceptions.InvalidClubException;
import com.rezzobg.exceptions.InvalidRestaurantException;
import com.rezzobg.exceptions.InvalidUserException;
import com.rezzobg.exceptions.UserIsLoggedInException;
import com.rezzobg.models.Club;
import com.rezzobg.services.ClubService;
import com.rezzobg.services.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    @GetMapping("/clubs")
    public List<PlaceDtoForList> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{cityId}/clubs")
    public List<PlaceDtoForList> getAllClubsByCity(@PathVariable(required = false) Long cityId) {
        return clubService.getAllClubsByCity(cityId);
    }

    @GetMapping("/clubs/{clubId}")
    public Club getClubDetails(@PathVariable(required = false) Long clubId) throws InvalidClubException {
        return clubService.getClubDetails(clubId);
    }

    @PostMapping("/clubs")
    public void addClub(@Valid @RequestBody PlaceDTO placeDTO, HttpServletRequest request) throws
            InvalidUserException, UserIsLoggedInException{
        this.clubService.addClub(placeDTO);
        if (UserStory.isUserLogged(request)) {
            if (UserStory.isAdminLogged(request)) {
                this.clubService.addClub(placeDTO);
            } else {
                throw new InvalidUserException("The user does not have rights for this operation!");
            }
        } else {
            throw new UserIsLoggedInException("User is not logged in!");
        }
    }
}
