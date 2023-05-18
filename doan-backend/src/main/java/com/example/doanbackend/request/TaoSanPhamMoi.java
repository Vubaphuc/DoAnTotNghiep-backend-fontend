package com.example.doanbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaoSanPhamMoi {
    private Integer id;
    private String hangSanPham;
    private String model;
    private String soIME;
    private String tenLoi;
    private double giaTien;

}
