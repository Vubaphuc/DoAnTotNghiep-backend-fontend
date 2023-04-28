package com.example.doanbackend.service.interfaceservice;


import com.example.doanbackend.entity.User;

public interface IUserService {
    User save(User user);
    User updateById(Integer id);
    User deleteById(Integer id);
}
