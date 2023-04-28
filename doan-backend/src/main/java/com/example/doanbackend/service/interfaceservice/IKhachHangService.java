package com.example.doanbackend.service.interfaceservice;

import com.example.doanbackend.entity.KhachHang;

public interface IKhachHangService {
    KhachHang save (KhachHang khachHang);
    KhachHang deleteById(Integer id);

    KhachHang updateById(Integer id);
}
