package com.rezzobg.controllers;

import com.rezzobg.dto.EventDTO;
import com.rezzobg.dto.EventDetailsDTO;
import com.rezzobg.dto.EventDtoForList;
import com.rezzobg.exceptions.InvalidEventException;
import com.rezzobg.exceptions.InvalidPlaceException;
import com.rezzobg.exceptions.InvalidUserException;
import com.rezzobg.exceptions.UserIsLoggedInException;
import com.rezzobg.services.EventService;
import com.rezzobg.services.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<EventDtoForList> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{eventId}")
    public EventDetailsDTO getOfferDetails(@PathVariable(required = false) Long eventId) throws
            InvalidEventException, InvalidPlaceException {
        return eventService.getEventDetails(eventId);
    }

    @PostMapping("/events")
    public Long addEvent(@Valid @RequestBody EventDTO eventDTO, HttpServletRequest request) throws InvalidPlaceException,
            InvalidUserException, UserIsLoggedInException{
        if (UserStory.isUserLogged(request)) {
            if (UserStory.isAdminLogged(request)) {
                return eventService.addEvent(eventDTO);
            } else {
                throw new InvalidUserException("User does not have rights for this operation!");
            }
        } else {
            throw new UserIsLoggedInException("User is not logged in!");
        }
    }
}
