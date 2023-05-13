package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.entity.Role;

public interface IRoleService {
    Role save(Role role);
    Role updateById(Integer id);
    Role deleteById(Integer id);
}
