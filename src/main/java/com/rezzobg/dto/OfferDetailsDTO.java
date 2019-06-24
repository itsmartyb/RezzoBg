package com.rezzobg.dto;

import com.rezzobg.models.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class OfferDetailsDTO {
    private Long id;
    private String pictureUrl;
    private String description;
    private String title;
    private LocalDate date;
    private int price;
    private Place place;
}
