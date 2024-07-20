package com.vermau2k01.RentRead.controller;

import com.vermau2k01.RentRead.dtos.UserDto;
import com.vermau2k01.RentRead.entity.User;
import com.vermau2k01.RentRead.service.IRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private IRegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDto userDto) {
        User user = registerService.registerUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
