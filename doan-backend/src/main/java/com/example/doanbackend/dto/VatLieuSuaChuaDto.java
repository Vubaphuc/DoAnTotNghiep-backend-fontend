package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VatLieuSuaChuaDto {
    private String code;
    private String tenModel;
    private String loaiLinhKien;
}
