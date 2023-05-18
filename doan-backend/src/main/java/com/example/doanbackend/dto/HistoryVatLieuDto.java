package com.example.doanbackend.dto;

import com.example.doanbackend.entity.Vendor;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryVatLieuDto {
    private Integer id;
    private String maVatLieu;
    private String tenModel;
    private String loaiLinhKien;
    private List<Vendor> vendor;
    private Integer soLuong;
    private LocalDateTime ngayTaoMoi;
    private LocalDateTime ngayCapNhat;
    private String maNhanVienTaoMoi;
    private String fullNameNhanVienTao;
}
