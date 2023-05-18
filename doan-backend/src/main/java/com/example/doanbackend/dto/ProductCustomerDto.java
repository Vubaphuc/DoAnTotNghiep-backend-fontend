package com.example.doanbackend.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCustomerDto {
    private Integer id;
    private String model;
    private String hangSanXuat;
    private String IME;
    private Integer idKH;
    private String fullNameKh;
    private String phoneKh;
    private String emailKh;
    private String addressKh;
}
