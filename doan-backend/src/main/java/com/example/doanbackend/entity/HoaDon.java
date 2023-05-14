package com.example.doanbackend.entity;

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
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "ma_hoa_don", unique = true)
    private String maHoaDon;
    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "thanh_tien")
    private double thanhTien;
    @Column(name = "ngay_tao_hoa_don")
    private LocalDateTime ngayTaoHoaDon;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;


    @OneToMany(mappedBy = "hoaDon", orphanRemoval = true)
    private List<SanPham> sanPhams = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_tao_hoa_don_id")
    private User nguoiTaoHoaDon;

    @PrePersist()
    public void prePersist() {
        this.ngayTaoHoaDon = LocalDateTime.now();
    }

}