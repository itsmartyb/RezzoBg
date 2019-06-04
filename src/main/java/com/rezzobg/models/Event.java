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

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    public Event(String pictureUrl, String description, String title, LocalDate date, String actorsName, Club club) {
        super(1l, pictureUrl, description, title, date);
        this.actorsName = actorsName;
        this.club = club;
    }
}
