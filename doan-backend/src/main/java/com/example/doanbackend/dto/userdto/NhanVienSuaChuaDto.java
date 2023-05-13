package com.example.doanbackend.dto.userdto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NhanVienSuaChuaDto {
    private Integer id;
    private String maNhanVien;
    private String fullName;
}
