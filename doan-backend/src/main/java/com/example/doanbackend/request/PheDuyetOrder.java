package com.example.doanbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PheDuyetOrder {
    private String maVatLieu;
    private Integer soLuong;
    private boolean trangThai;
}
