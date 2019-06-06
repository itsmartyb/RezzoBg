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
@Table(name = "events")
public class Event extends Proposal{
    private String actorsName;

    public Event(String pictureUrl, String description, String title, LocalDate date, String actorsName, Place place) {
        super(1l, pictureUrl, description, title, date, place);
        this.actorsName = actorsName;
    }
}
