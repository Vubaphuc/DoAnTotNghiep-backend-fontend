package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NhanVienDto {
    private Integer id;
    private String maNhanVien;
    private String fullName;
}
