package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaoHanhDto {
    private Integer id;
    private Integer sanPhamId;
    private String model;
    private String hangSanXuat;
    private String ime;
    private String tenLoi;
    private boolean trangThai;
}
