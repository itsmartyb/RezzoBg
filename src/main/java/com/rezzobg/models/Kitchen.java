package com.rezzobg.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "kitchens")
@Getter
@Setter
@NoArgsConstructor
public class Kitchen extends Characteristic {
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Kitchen(String name) {
        super(1l, name);
    }

}
