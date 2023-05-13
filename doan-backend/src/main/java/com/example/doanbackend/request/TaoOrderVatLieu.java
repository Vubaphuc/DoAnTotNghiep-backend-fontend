package com.example.doanbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaoOrderVatLieu {
    private String code;
    private String loaiLinhKien;
    private Integer soLuong;
}