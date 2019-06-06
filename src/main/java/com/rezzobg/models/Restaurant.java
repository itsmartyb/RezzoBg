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
@Table(name = "restaurants")
public class Restaurant extends Place {
    private String kitchen;

    public Restaurant(String name, Time startWorkingDay, Time endWorkingDay,
                      double rating, String description, int places, Address address, String kitchen) {

        super(1l, name, startWorkingDay, endWorkingDay, rating, description, places, address);
        this.kitchen = kitchen;
    }


}
