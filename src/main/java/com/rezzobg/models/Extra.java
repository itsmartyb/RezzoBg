package com.rezzobg.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "extras")
public class Extra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonBackReference
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "extras")
    private List<Place> places;

    public Extra(String name) {
        this.name = name;
    }
}
