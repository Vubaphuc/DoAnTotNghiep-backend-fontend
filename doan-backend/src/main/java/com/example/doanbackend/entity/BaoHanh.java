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
@Table(name = "bao_hanh")
public class BaoHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "Ma_So_Bao_Hanh", unique = true)
    private String maSoBaoHanh;
    @Column(name = "ngay_kich_hoat")
    private LocalDateTime ngayKichHoat;
    @Column(name = "ngay_het_han")
    private LocalDateTime ngayHetHan;
    @Column(name = "trang_thai_bao_hanh")
    private boolean trangThaiBaoHanh = true;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "linh_kien_id")
    private LinhKien linhKien;

    @ManyToOne
    @JoinColumn(name = "hoa_don_id")
    private HoaDon hoaDon;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "san_pham_id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;

    @PrePersist
    public void prePersist () {
        this.ngayKichHoat = LocalDateTime.now();
        this.ngayHetHan = ngayKichHoat.plusMonths(linhKien.getThoiGianBaoHanh());
        if (LocalDateTime.now().isEqual(ngayHetHan)) {
            this.trangThaiBaoHanh = false;
        }
   }

}