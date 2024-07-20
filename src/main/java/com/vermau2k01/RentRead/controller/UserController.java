package com.vermau2k01.RentRead.controller;

import com.vermau2k01.RentRead.entity.User;
import com.vermau2k01.RentRead.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.getUsers();

        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") UUID id)
    {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") UUID id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
