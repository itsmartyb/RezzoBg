package com.rezzobg.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;


@Table(name = "places")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
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
    private String midAmount;
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
    private List<Proposal> proposals;
    @OneToMany(mappedBy = "place")
    private List<Comment> comments;
    @OneToMany(mappedBy = "place")
    private List<Photo> photos;

    public Place(Long id, String name, Time startWorkingDay, Time endWorkingDay,
                 String midAmount, double rating, String description, int places, Address address) {
        this.id = id;
        this.name = name;
        this.startWorkingDay = startWorkingDay;
        this.endWorkingDay = endWorkingDay;
        this.midAmount = midAmount;
        this.rating = rating;
        this.description = description;
        this.places = places;
        this.address = address;
        this.proposals = new LinkedList<>();
        this.comments = new LinkedList<>();
        this.photos = new LinkedList<>();
    }
}
