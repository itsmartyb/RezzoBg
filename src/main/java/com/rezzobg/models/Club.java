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
@Table(name = "clubs")
public class Club extends Place {
    @ManyToMany
    @JsonManagedReference
    @JoinTable(
            name = "clubs_has_genres",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    public Club(String name, Time startWorkingDay, Time endWorkingDay, String midAmount,
                      double rating, String description, int places, Address address) {

        super(null, name, startWorkingDay, endWorkingDay, midAmount, rating, description, places, address);
    }
}
