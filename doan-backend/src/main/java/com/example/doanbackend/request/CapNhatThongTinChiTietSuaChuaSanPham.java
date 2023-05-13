package com.example.doanbackend.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapNhatThongTinChiTietSuaChuaSanPham {
    private String nguyenNhanLoi;
    private String viTriSua;
    private String chuThich;
    private String trangThai;
}
