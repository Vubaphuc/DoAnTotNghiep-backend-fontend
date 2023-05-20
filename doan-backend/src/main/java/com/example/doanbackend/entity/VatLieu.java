package com.example.doanbackend.entity;

import com.example.doanbackend.dto.DanhSachVenderDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vat_lieu")
public class VatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "code", unique = true)
    private String code;
    @Column(name = "ten_model")
    private String tenModel;
    @Column(name = "so_luong")
    private int soLuong;
    @Column(name = "ngay_tao_vat_lieu")
    private LocalDateTime ngayTaoVatLieu;
    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhat;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linh_kien_id")
    private LinhKien linhKien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhan_vien_nhap_id")
    private User nhanVienNhap;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @PrePersist()
    public void prePersist() {
        this.ngayTaoVatLieu = LocalDateTime.now();
    }

    @PostUpdate()
    public void postUpdate() {
        this.ngayCapNhat = LocalDateTime.now();
    }

}