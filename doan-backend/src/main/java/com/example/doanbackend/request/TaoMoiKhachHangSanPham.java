package com.example.doanbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaoMoiKhachHangSanPham {
    private String fullNameKhachHang;
    private String phoneNumber;
    private String email;
    private String address;
    private String model;
    private String hangSanXuat;
    private String IME;
    private String tenLoi;
    private Integer soLuong;
    private String nguyenNhanLoi;
    private String giaTien;
}
