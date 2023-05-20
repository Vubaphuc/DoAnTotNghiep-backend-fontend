package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Integer id;
    private String maOrder;
    private String maVatLieu;
    private String tenModel;
    private String loaiLinhKien;
    private Integer soLuong;
    private boolean trangThai;
}
