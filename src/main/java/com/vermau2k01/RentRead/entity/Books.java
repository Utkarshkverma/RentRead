package com.vermau2k01.RentRead.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Books {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private boolean isAvailable;
    @OneToMany(mappedBy = "books")
    private List<Rental> rentals = new ArrayList<>();

}
