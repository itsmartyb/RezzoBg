package com.rezzobg.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "theatres")
public class Theatre extends Place{
    @OneToMany(mappedBy = "theatre")
    private Set<Genre> genres = new HashSet<>();

    public Theatre(String name, Time startWorkingDay, Time endWorkingDay,
                      double rating, String description, int places, Address address, String actorNames) {

        super(1l, name, startWorkingDay, endWorkingDay, rating, description, places, address);
    }
}
