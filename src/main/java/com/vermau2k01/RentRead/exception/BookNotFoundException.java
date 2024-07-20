package com.vermau2k01.RentRead.exception;

public class BookNotFoundException extends RuntimeException {

    String id;
    public BookNotFoundException(String id) {
        super(String.format("Book not found with id %s", id));
    }
}
