package com.rezzobg.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private int places;
    private int discount;
    private String description;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Time startTime;
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
}
