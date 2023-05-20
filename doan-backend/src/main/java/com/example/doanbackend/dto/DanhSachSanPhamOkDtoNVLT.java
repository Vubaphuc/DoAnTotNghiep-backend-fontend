package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DanhSachSanPhamOkDtoNVLT {
    private Integer id;
    private String model;
    private String hangSanXuat;
    private String IME;
    private String tenLoi;
    private String viTriSua;
    private boolean trangThai;
    private Integer soLuong;
    private double giaTien;
    private double thanhTien;
}
