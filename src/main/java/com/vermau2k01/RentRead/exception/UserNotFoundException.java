package com.vermau2k01.RentRead.exception;

public class UserNotFoundException extends RuntimeException {
    String id;
    public UserNotFoundException(String id) {
        super(String.format("User with id %s not found", id));
    }
}
