package com.example.doanbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DangKyKhachHangSanPhamMoi {
    private String fullNameKH;
    private String phoneKH;
    private String emailKH;
    private String addressKH;
    private String hangSanPham;
    private String model;
    private String soIME;
    private String tenLoi;
    private Integer soLuong;
    private double giaTien;
    private double thanhTien;
}
