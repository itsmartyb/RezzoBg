package com.rezzobg.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "places")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Place {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private Time startWorkingDay;
    @Column
    private Time endWorkingDay;
    @Column
    private double rating;
    @Column
    private String description;
    @Column
    private int places;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "place")
    List<Proposal> proposals;
    @OneToMany(mappedBy = "place")
    List<Comment> comments;
    @OneToMany(mappedBy = "place")
    List<Photo> photos;
    @OneToMany(mappedBy = "place")
    List<Booking> bookings;

    public Place(Long id, String name, Time startWorkingDay, Time endWorkingDay, double rating, String description, int places, Address address) {
        this.id = id;
        this.name = name;
        this.startWorkingDay = startWorkingDay;
        this.endWorkingDay = endWorkingDay;
        this.rating = rating;
        this.description = description;
        this.places = places;
        this.address = address;
        this.proposals = new LinkedList<>();
        this.comments = new LinkedList<>();
        this.photos = new LinkedList<>();
        this.bookings = new LinkedList<>();
    }
}
