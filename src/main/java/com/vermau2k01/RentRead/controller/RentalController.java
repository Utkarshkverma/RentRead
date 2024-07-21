package com.vermau2k01.RentRead.controller;

import com.vermau2k01.RentRead.entity.Rental;
import com.vermau2k01.RentRead.service.IRentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RentalController {

    private final IRentalService rentalService;


    @PostMapping("/books/{booksId}/rent")
    public ResponseEntity<Rental> rentBook(@PathVariable UUID booksId) {

        Rental rental = rentalService.borrowBook(booksId);
        return new ResponseEntity<>(rental, HttpStatus.ACCEPTED);
    }

    @PostMapping("/books/{booksId}/return")
    public ResponseEntity<Rental> returnBook(@PathVariable UUID booksId)
    {
        Rental rental = rentalService.returnBook(booksId);
        return new ResponseEntity<>(rental, HttpStatus.ACCEPTED);
    }



    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/rental/all-pending-rentals")
    public ResponseEntity<List<Rental>> getAllRentals()
    {
        List<Rental> rentals = rentalService.getAllRentals();
        return new ResponseEntity<>(rentals, HttpStatus.OK);
    }
}
