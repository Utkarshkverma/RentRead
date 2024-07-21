package com.vermau2k01.RentRead.exception;

public class RentalNotExistsException extends RuntimeException {
    public RentalNotExistsException() {
        super("Rental doesn't exist for the book");
    }
}
