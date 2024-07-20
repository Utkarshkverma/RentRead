package com.vermau2k01.RentRead.service;

import com.vermau2k01.RentRead.dtos.UserDto;
import com.vermau2k01.RentRead.entity.User;

public interface IRegisterService {

    User registerUser(UserDto userDto);
}
