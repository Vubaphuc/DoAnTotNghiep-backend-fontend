package com.example.doanbackend.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DanhSachVatLieuDto {

    private String code;
    private String tenModel;
    private int soLuong;
    private String loaiLinhKien;
}
