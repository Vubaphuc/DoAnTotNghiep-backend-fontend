package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VatLieuSuaChuaDto {
    private Integer id;
    private String code;
    private String tenModel;
    private String loaiLinhKien;
}
