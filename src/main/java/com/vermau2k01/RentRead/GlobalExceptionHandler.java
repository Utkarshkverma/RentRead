package com.vermau2k01.RentRead;

import com.vermau2k01.RentRead.dtos.ErrorResponse;
import com.vermau2k01.RentRead.exception.BookLimitExceedException;
import com.vermau2k01.RentRead.exception.BookNotAvailableException;
import com.vermau2k01.RentRead.exception.BookNotFoundException;
import com.vermau2k01.RentRead.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorResponse err  = ErrorResponse
                .builder()
                .message(ex.getMessage())
                .success(false)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponse err = ErrorResponse
                .builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .success(false)
                .build();

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex) {
        ErrorResponse err = ErrorResponse
                .builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .success(false)
                .build();

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotAvailableException.class)
    public ResponseEntity<ErrorResponse> handleBookNotAvailableException
            (BookNotAvailableException ex) {
        ErrorResponse err = ErrorResponse
                .builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .success(false)
                .build();

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookLimitExceedException.class)
    public ResponseEntity<ErrorResponse> handleBookLimitExceedException
            (BookLimitExceedException ex) {
        ErrorResponse err = ErrorResponse
                .builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .success(false)
                .build();

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }



}
