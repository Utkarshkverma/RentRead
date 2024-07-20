package com.vermau2k01.RentRead.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "User name cannot be blank")
    @NotEmpty(message = "User name cannot be empty")
    private String name;
    @Email(message = "Please provide a valid email id")
    private String email;
    @Size(min = 4,message = "Password must be at least 4 characters long")
    private String password;


    private String role;


}
