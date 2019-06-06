package com.rezzobg.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "proposals")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Proposal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String pictureUrl;
    private String description;
    private String title;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public Proposal(Long id, String pictureUrl, String description, String title, LocalDate date, Place place) {
        this.id = id;
        this.pictureUrl = pictureUrl;
        this.description = description;
        this.title = title;
        this.date = date;
        this.place = place;
    }
}
