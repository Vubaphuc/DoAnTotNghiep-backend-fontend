package com.example.doanbackend.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhachHangDto {
    private Integer id;
    private String maKhachHang;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
}
