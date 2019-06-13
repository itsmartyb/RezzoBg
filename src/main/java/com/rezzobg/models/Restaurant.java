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
@Table(name = "restaurants")
public class Restaurant extends Place {
    @ManyToMany
    @JoinTable(
            name = "restaurant_has_kitchen",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "kitchen_id"))
    private Set<Kitchen> kitchens = new HashSet<>();

    public Restaurant(String name, Time startWorkingDay, Time endWorkingDay, String midAmount,
                      double rating, String description, int places, Address address, String kitchen) {
        super(null, name, startWorkingDay, endWorkingDay, midAmount, rating, description, places, address);
    }
}
