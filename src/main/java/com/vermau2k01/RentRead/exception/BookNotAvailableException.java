package com.vermau2k01.RentRead.exception;

public class BookNotAvailableException extends RuntimeException{
    public BookNotAvailableException(){
        super("Book is not available");
    }
}
