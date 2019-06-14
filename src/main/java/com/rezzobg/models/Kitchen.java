package com.rezzobg.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kitchens")
@Getter
@Setter
@NoArgsConstructor
public class Kitchen extends Characteristic {
    @ManyToMany(mappedBy = "kitchens")
    @JsonBackReference
    private List<Restaurant> restaurants;

    public Kitchen(String name) {
        super(null, name);
    }

}
