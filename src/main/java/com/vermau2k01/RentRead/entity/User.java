package com.vermau2k01.RentRead.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    @NaturalId(mutable = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "users",fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Rental> rentals = new ArrayList<>();

    @Transient
    public List<UUID> getBooks() {
        List<UUID> books_rented = new ArrayList<>();
        for (Rental rental : rentals) {
            if (rental.getBooks() != null) {
                books_rented.add(rental.getBooks().getId());
            }
        }
        return books_rented;
    }


}
