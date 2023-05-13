package com.example.doanbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaoVatLieuMoi {
    private String maVatLieu;
    private String tenModel;
    private Integer venderId;
    private Integer loaiLinhKienId;
    private Integer soLuong;
}
