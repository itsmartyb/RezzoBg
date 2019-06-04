package com.rezzobg.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "offers")
public class Offer extends Proposal {
    private int price;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Offer(Place place, String pictureUrl, String description, String title, LocalDate date, int price) {
        super(1l, place, pictureUrl, description, title, date);
        this.price = price;
    }
}
