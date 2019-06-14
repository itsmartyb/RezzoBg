package com.rezzobg.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "genres")
public class Genre extends Characteristic {

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference
    private List<Club> clubs;

    public Genre(String name) {
        super(null, name);
    }
}
