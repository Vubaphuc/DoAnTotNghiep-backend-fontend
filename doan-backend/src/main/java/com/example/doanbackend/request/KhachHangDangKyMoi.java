package com.example.doanbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangDangKyMoi {
    private String fullNameKhachHang;
    private String phoneNumber;
    private String email;
    private String address;
}
