package com.rezzobg.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//
//    @Override
//    public int hashCode() {
//        return this.name.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return this.name.equals(Ci;
//    }
}
