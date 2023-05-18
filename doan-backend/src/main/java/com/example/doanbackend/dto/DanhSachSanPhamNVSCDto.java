package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DanhSachSanPhamNVSCDto {
    private Integer id;
    private String model;
    private String hangSanXuat;
    private String IME;
    private String tenLoi;
    private boolean trangThai;
}
