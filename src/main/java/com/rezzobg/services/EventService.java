package com.rezzobg.services;

import com.rezzobg.dto.EventDtoForList;
import com.rezzobg.models.Event;
import com.rezzobg.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<EventDtoForList> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        //az sum ebati prostaka
        return events.stream().map(event -> new EventDtoForList(event.getTitle(), event.getPictureUrl(), event.getActorsName()))
                .collect(Collectors.toList());
    }
}

