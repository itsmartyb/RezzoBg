package com.rezzobg.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String telephone;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column
    private LocalDate dateOfBirth;
    @Column
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    @Column
    private boolean isAdmin;

    public User(String username, String password, String firstName, String lastName, String telephone, Address address, LocalDate dateOfBirth) {
        this.id = null;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.comments = new LinkedList<>();
    }
}
