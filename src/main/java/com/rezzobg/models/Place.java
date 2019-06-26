package com.rezzobg.models;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Table(name = "places")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property="place")
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
    private int discount;
    @Column
    private int places;
    @Column
    private LocalDate date;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "place")
    @JsonManagedReference
    private List<Proposal> proposals;
    @OneToMany(mappedBy = "place")
    @JsonManagedReference
    private List<Comment> comments;
    @OneToMany(mappedBy = "place")
    @JsonManagedReference
    private List<Photo> photos;
    @ManyToMany
    @JoinTable(
            name = "places_has_extras",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "extra_id"))
    @JsonManagedReference
    private List<Extra> extras;

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
        this.extras = new LinkedList<>();
        this.date = LocalDate.now();
    }
}
