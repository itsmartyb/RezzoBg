package com.rezzobg.controllers;

import com.rezzobg.dto.EventDetailsDTO;
import com.rezzobg.dto.EventDtoForList;
import com.rezzobg.exceptions.InvalidEventException;
import com.rezzobg.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public EventDetailsDTO getOfferDetails(@PathVariable(required = false) Long eventId) throws InvalidEventException {
        return eventService.getOfferDetails(eventId);
    }
}
