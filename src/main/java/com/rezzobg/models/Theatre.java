package com.rezzobg.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Time;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "theatres")
public class Theatre extends Place{
    private String actorNames;

    public Theatre(String name, Time startWorkingDay, Time endWorkingDay,
                      double rating, String description, int places, Address address, String actorNames) {

        super(1l, name, startWorkingDay, endWorkingDay, rating, description, places, address);
        this.actorNames = actorNames;
    }


}