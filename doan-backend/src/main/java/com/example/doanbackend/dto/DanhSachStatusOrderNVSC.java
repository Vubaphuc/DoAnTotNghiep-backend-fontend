package com.example.doanbackend.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DanhSachStatusOrderNVSC {
    private Integer id;
    private String maOder;
    private String maVatLieu;
    private String tenModel;
    private String loaiLinhKien;
    private int soLuong;
    private String maNhanVienOrder;
    private String fullNameNguoiOrder;
    private boolean isStatus;
}
