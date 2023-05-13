package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DanhSachVenderDto {
    private Integer id;
    private String name;
    private long soLuongVatLieu;
}
