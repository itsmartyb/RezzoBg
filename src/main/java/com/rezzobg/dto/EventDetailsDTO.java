package com.rezzobg.dto;

import com.rezzobg.models.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EventDetailsDTO {
    private Long id;
    private String pictureUrl;
    private String description;
    private String title;
    private LocalDate date;
    private Time hour;
    private Place place;
}
