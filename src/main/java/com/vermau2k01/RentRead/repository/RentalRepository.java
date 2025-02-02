package com.vermau2k01.RentRead.repository;

import com.vermau2k01.RentRead.entity.Books;
import com.vermau2k01.RentRead.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RentalRepository extends JpaRepository<Rental, UUID> {

    Optional<Rental> findByBooks(Books books);
}
