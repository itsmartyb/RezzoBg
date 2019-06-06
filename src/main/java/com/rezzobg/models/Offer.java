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

    public Offer(String pictureUrl, String description, String title, LocalDate date, int price, Place place) {
        super(1l, pictureUrl, description, title, date, place);
        this.price = price;
    }
}
