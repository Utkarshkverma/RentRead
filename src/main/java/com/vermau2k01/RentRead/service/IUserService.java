package com.vermau2k01.RentRead.service;

import com.vermau2k01.RentRead.dtos.UserDto;
import com.vermau2k01.RentRead.entity.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    List<User> getUsers();
    User getUser(UUID id);
    void deleteUser(UUID id);
}
