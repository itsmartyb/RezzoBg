package com.rezzobg.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event extends Proposal{
    private Time hour;

    public Event(String pictureUrl, String description, String title, LocalDate date, Time hour, Place place) {
        super(null, pictureUrl, description, title, date, place);
        this.hour = hour;
    }
}
