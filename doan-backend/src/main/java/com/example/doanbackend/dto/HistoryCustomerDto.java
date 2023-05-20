package com.example.doanbackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryCustomerDto {private Integer id;
    private String maKhachHang;
    private String fullName;
    private String phone;
    private String email;
    private long soLuongSP;

}
