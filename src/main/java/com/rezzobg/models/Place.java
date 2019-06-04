package com.rezzobg.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Time;


@Entity
@Table(name = "places")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Place {

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
}
