package com.rezzobg.services;

import com.rezzobg.dto.EventDetailsDTO;
import com.rezzobg.dto.EventDtoForList;
import com.rezzobg.exceptions.InvalidEventException;
import com.rezzobg.models.Event;
import com.rezzobg.models.Place;
import com.rezzobg.models.Proposal;
import com.rezzobg.repositories.EventRepository;
import com.rezzobg.repositories.PlaceRepository;
import com.rezzobg.repositories.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PlaceRepository placeRepository;

    public List<EventDtoForList> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> new EventDtoForList(event.getTitle(), event.getPictureUrl(), event.getHour()))
                .collect(Collectors.toList());
    }

    public EventDetailsDTO getOfferDetails(Long id) throws InvalidEventException {
        Optional<Event> offerFromDB = eventRepository.findById(id);
        Event event = null;
        try {
            event  = offerFromDB.get();
        } catch(Exception e) {
            throw new InvalidEventException();
        }
        Optional<Place> place = placeRepository.findById(id);
        return new EventDetailsDTO(event.getId(), event.getPictureUrl(), event.getDescription(),
                event.getTitle(), event.getDate(), event.getHour(), place.get());
    }
}

