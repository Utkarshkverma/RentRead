package com.vermau2k01.RentRead.service;

import com.vermau2k01.RentRead.entity.Rental;

import java.util.List;
import java.util.UUID;

public interface IRentalService {

    Rental borrowBook(UUID bookId);
    Rental returnBook(UUID bookId);
    List<Rental> getAllRentals();
}
