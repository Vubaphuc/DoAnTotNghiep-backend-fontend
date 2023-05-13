package com.example.doanbackend.mapper;

import com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT;
import com.example.doanbackend.dto.userdto.UserDto;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.User;

public class KhachHangMapper {
    public static DanhSachKhachHangCoSanPhamNVLT toKhachHangDto(KhachHang khachHang, Integer count, String trangThai) {

        DanhSachKhachHangCoSanPhamNVLT danhSachKhachHangCoSanPhamNVLT = new DanhSachKhachHangCoSanPhamNVLT (
                khachHang.getMaKhachHang(),
                khachHang.getFullName(),
                khachHang.getPhoneNumber(),
                khachHang.getEmail(),
                count,
                trangThai



        );
        return danhSachKhachHangCoSanPhamNVLT;
    }
}
