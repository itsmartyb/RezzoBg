package com.rezzobg.services;

import com.rezzobg.dto.EventDTO;
import com.rezzobg.dto.EventDetailsDTO;
import com.rezzobg.dto.EventDtoForList;
import com.rezzobg.exceptions.InvalidEventException;
import com.rezzobg.exceptions.InvalidPlaceException;
import com.rezzobg.models.Event;
import com.rezzobg.models.Place;
import com.rezzobg.repositories.EventRepository;
import com.rezzobg.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public EventDetailsDTO getEventDetails(Long id) throws InvalidEventException, InvalidPlaceException {
        Optional<Event> eventFromDB = eventRepository.findById(id);
        Event event = null;
        try {
            event  = eventFromDB.get();
        } catch(Exception e) {
            throw new InvalidEventException();
        }
        return new EventDetailsDTO(event.getId(), event.getPictureUrl(), event.getDescription(),
                event.getTitle(), event.getDate(),
                event.getHour(), placeRepository.findByName(event.getPlace().getName()));
    }

    public Long addEvent(EventDTO eventDTO) throws InvalidPlaceException {
        if(placeRepository.findByName(eventDTO.getPlaceName()) == null) {
            throw new InvalidPlaceException();
        }
        Event event = new Event(eventDTO.getUrl(), eventDTO.getDescription(), eventDTO.getTitle(),
                eventDTO.getDate(), eventDTO.getHour(), placeRepository.findByName(eventDTO.getPlaceName()));
        eventRepository.save(event);
        return event.getId();
    }
}

