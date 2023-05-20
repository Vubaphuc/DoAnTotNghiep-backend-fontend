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
@Table(name = "thong_tin_bao_hanh")
public class ThongTinBaoHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "ten_loi")
    private String tenLoi;
    @Column(name = "nguyen_nhan_gay_loi")
    private String nguyenNhanGayLoi;
    // LoaiBaoHanh = true : có tính phí, LoaiBaoHanh = false : không tinh phi
    @Column(name = "loai_bao_hanh")
    private boolean LoaiBaoHanh;
    @Column(name = "gia_tien")
    private double giaTien;
    @Column(name = "ngay_nhan_san_pham")
    private LocalDateTime ngayNhanBaoHanh;
    @Column(name = "ngay_tra_san_pham")
    private LocalDateTime ngayTraSanPham;
    // isStatus = false : đang pending chờ sửa, isStatus = true : đã sửa chữa xong
    @Column(name = "trang_thai")
    private boolean isStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhan_vien_bao_hanh_id")
    private User nhanVienBaoHanh;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "san_pham_id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhan_vien_tra_san_pham_id")
    private User nhanVienTraSanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thong_tin_sua_chua_id")
    private ThongTinSuaChua thongTinSuaChua;

    @PrePersist
    public void prePersist() {
        this.ngayNhanBaoHanh = LocalDateTime.now();
        this.isStatus = false;
    }
}