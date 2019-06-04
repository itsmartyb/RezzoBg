package com.rezzobg.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastname;
    @Column
    private String telephone;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private boolean isAdmin;
}
