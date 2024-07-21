package com.vermau2k01.RentRead.service;


import com.vermau2k01.RentRead.dtos.UserDto;
import com.vermau2k01.RentRead.entity.User;
import com.vermau2k01.RentRead.exception.UserNotExistsException;
import com.vermau2k01.RentRead.exception.UserNotFoundException;
import com.vermau2k01.RentRead.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(UUID id) {
        return userRepository
                .findById(id)
                .orElseThrow(()->new UserNotFoundException(id.toString()));
    }


    @Override
    public void deleteUser(UUID id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(id.toString()));
        userRepository.delete(user);
    }

    @Override
    public String getUserDetails() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        return authentication.getName();
    }

    @Override
    public User getMyDetails() {

        String email = getUserDetails();
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UserNotExistsException(getUserDetails()));

    }


}
