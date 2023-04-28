package com.example.doanbackend.service.interfaceservice;

import com.example.doanbackend.entity.NhanVien;

public interface INhanVienService {

    NhanVien save(NhanVien nhanVien);
    NhanVien updateById(Integer id);
    NhanVien deleteById(Integer id);
}
