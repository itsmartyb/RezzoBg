package com.rezzobg.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "extras")
public class Extra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "places_has_extras",
            joinColumns = @JoinColumn(name = "extra_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id"))
    private Set<Place> places;
}
