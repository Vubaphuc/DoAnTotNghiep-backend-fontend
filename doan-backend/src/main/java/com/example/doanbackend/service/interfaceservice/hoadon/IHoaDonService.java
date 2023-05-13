package com.example.doanbackend.service.interfaceservice.hoadon;

import com.example.doanbackend.entity.HoaDon;

public interface IHoaDonService {

    HoaDon save(HoaDon hoaDon);
    HoaDon updateById(Integer id);
    HoaDon deleteById(Integer id);
}
