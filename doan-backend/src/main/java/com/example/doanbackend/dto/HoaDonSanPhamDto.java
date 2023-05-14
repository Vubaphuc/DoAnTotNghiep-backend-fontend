package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoaDonSanPhamDto {
    private Integer id;
    private String fullNameKH;
    private String phoneKH;
    private String emailKH;
    private String hangSanPham;
    private String model;
    private String soIME;
    private String tenLoi;
    private String viTriSua;
    private String loaiBaoHanh;
    private int thoiGianBaoHanh;
    private int soLuong;
    private double giaTien;
    private double thanhTien;
}
