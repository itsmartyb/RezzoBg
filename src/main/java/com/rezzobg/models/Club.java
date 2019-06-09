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
@Table(name = "clubs")
public class Club extends Place {
    @OneToMany(mappedBy = "club")
    private Set<Genre> genres = new HashSet<>();

    public Club(String name, Time startWorkingDay, Time endWorkingDay, String midAmount,
                      double rating, String description, int places, Address address, String genre) {

        super(null, name, startWorkingDay, endWorkingDay, midAmount, rating, description, places, address);
    }
}
