package com.example.doanbackend.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryNhanVienLeTanDto {
    private Integer id;
    private String model;
    private String hangSanPham;
    private String IME;
    private String tenLoi;
    private boolean trangThai;
    private String maNhanVienNhan;
    private String fullNameNhanVienNhan;
    private LocalDateTime ngayNhan;
    private String loaiLinhKien;
    private String maNhanVienSuaChua;
    private String fullNameNhanVienSuaChua;
    private LocalDateTime ngayHoanThanh;
    private String maNhanVienTra;
    private String fullNameNhanVienTra;
    private LocalDateTime ngayTra;
    private String maBaoHanh;
}
