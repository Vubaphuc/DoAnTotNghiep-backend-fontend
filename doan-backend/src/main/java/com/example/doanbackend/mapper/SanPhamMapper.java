package com.example.doanbackend.mapper;

import com.example.doanbackend.dto.KhachHangDto;
import com.example.doanbackend.dto.SanPhamDto;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.SanPham;

public class SanPhamMapper {
    public static SanPhamDto toSanPhamDto(SanPham sanPham) {

        SanPhamDto sanPhamDto = new SanPhamDto (
                sanPham.getId(),
                sanPham.getModel(),
                sanPham.getHangSanXuat(),
                sanPham.getIME()
        );

        return sanPhamDto;
    }
}
