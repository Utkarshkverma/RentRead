package com.vermau2k01.RentRead.exception;

public class BookLimitExceedException extends RuntimeException {
    public BookLimitExceedException() {
        super(String.format("Book limit exceeds the book limit"));
    }
}
