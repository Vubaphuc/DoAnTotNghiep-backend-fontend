package com.example.doanbackend.mapper;

import com.example.doanbackend.dto.KhachHangDto;
import com.example.doanbackend.dto.userdto.UserDto;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.User;

public class KhachHangMapper {
    public static KhachHangDto toKhachhangDto(KhachHang khachHang) {

        KhachHangDto khachHangDto = new KhachHangDto (
                khachHang.getId(),
                khachHang.getMaKhachHang(),
                khachHang.getFullName(),
                khachHang.getPhoneNumber(),
                khachHang.getEmail(),
                khachHang.getAddress()

        );
        return khachHangDto;
    }
}
