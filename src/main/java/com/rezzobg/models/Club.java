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
@Table(name = "clubs")
public class Club extends Place {
    private String genre;

    public Club(String name, Time startWorkingDay, Time endWorkingDay,
                      double rating, String description, int places, Address address, String genre) {

        super(1l, name, startWorkingDay, endWorkingDay, rating, description, places, address);
        this.genre = genre;
    }
}
