package com.vermau2k01.RentRead.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author's name is required")
    private String author;
    @NotBlank(message = "Please enter the genre")
    private String genre;

}
