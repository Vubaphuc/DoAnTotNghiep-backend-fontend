package com.example.doanbackend.mapper;

import com.example.doanbackend.dto.userdto.UserDto;
import com.example.doanbackend.entity.User;


public class UserMapper {
    public static UserDto toUserDto(User user) {

        UserDto userDto = new UserDto (
                user.getId(),
                user.getMaNhanVien(),
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getRoles()

        );
        return userDto;
    }
}
