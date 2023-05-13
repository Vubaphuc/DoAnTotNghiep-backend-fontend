package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DanhSachVatLieuTheoVendorDto {
    private String code;
    private String tenModel;
    private int soLuong;
    private String loaiLinhKien;
    private String nameVendor;
}
