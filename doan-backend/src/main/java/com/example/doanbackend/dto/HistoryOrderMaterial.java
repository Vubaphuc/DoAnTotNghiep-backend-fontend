package com.example.doanbackend.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryOrderMaterial {
    private Integer id;
    private String orderCode;
    private Integer quantity;
    private boolean isStatus;
    private String maNhanVienOrder;
    private String fullNameNhanVienOrder;
    private LocalDateTime ngayOrder;
    private String maNhanVienPhDuyet;
    private String fullNameNhanVienPheDuyet;
    private LocalDateTime ngayPheDuyet;
    private String loaiLinhKien;
    private String maVatLieu;
    private String tenModel;
    private String nameVendor;

}
