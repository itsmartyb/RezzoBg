package com.rezzobg.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    @JoinTable(
            name = "restaurants_has_kitchens",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "kitchen_id"))
    private Set<Kitchen> kitchens = new HashSet<>();

    public Restaurant(String name, Time startWorkingDay, Time endWorkingDay, String midAmount,
                      double rating, String description, int places, Address address) {
        super(null, name, startWorkingDay, endWorkingDay, midAmount, rating, description, places, address);
    }
}
