package com.example.doanbackend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryMaterialDto {
    private Integer id;
    private String maVatLieu;
    private String tenModel;
    private String loaiLinhKien;
    private String nameVendor;
    private Integer soLuong;
    private String maNhanVienNhap;
    private String fullNameNhanVienNhap;
    private LocalDateTime ngayNhap;
    private LocalDateTime ngayCapNhat;
}
