package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.entity.BaoHanh;

public interface IBaoHanhService {
    BaoHanh save(BaoHanh baoHanh);
    BaoHanh updateById(Integer id);
    BaoHanh deleteById(Integer id);
}
