package com.example.doanbackend.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SanPhamChuaSuaDto {
    private Integer id;
    private String model;
    private String hangSanXuat;
    private String ime;
    private String tenLoi;
    private boolean trangThai;
}
