package com.rezzobg.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genres")
public class Genre extends Characteristic {

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    public Genre(String name) {
        super(null, name);
    }
}