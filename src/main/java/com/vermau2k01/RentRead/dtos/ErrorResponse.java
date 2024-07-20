package com.vermau2k01.RentRead.dtos;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private boolean success;
    private HttpStatus httpStatus;
}
