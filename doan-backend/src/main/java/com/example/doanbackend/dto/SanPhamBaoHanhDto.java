package com.example.doanbackend.dto;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SanPhamBaoHanhDto {
    private Integer id;
    private String model;
    private String hangSanXuat;
    private String IME;
    private String tenLoi;
    private String fullNameKH;
    private String phoneKh;
    private boolean isRepair;
    private boolean isStatus;

}
