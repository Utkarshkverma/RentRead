package com.vermau2k01.RentRead.exception;

public class UserNotExistsException extends RuntimeException{

    String email;
    public UserNotExistsException(String email) {
        super(String.format("User doesn't exists with email %s", email));
    }
}
