package com.example.doanbackend.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SanPhamDto {
    private Integer id;
    private String model;
    private String hangSanXuat;
    private String IME;
}
