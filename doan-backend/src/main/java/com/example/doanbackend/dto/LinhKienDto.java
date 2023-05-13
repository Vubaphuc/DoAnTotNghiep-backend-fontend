package com.example.doanbackend.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LinhKienDto {
    private Integer id;
    private String name;
    private Integer thoiGianBaoHanh;
}
