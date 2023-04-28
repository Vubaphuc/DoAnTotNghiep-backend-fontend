package com.example.doanbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String model;
    private String hangSanXuat;
    private String IME;
    private String tenLoi;
    private Integer soLuong;
    private String nguyenNhanLoi;
    private LocalDateTime ngayNhanSanPham;
    private String trangThai;
    private LocalDateTime ngayTra;
    private double thanhTien;

    @ManyToOne
    @JoinColumn(name = "hoa_don_id")
    private HoaDon hoaDon;

}