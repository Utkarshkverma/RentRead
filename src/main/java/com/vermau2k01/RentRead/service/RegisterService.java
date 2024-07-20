package com.vermau2k01.RentRead.service;

import com.vermau2k01.RentRead.dtos.UserDto;
import com.vermau2k01.RentRead.entity.User;
import com.vermau2k01.RentRead.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements  IRegisterService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole()==null?"USER":userDto.getRole());
        return userRepository.save(user);
    }
}
