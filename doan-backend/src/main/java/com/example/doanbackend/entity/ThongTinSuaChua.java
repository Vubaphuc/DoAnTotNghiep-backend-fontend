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
@Table(name = "thong_tin_sua_chua")
public class ThongTinSuaChua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nguyen_nhan_loi")
    private String nguyenNhanLoi;
    @Column(name = "ngay_hoan_thanh")
    private LocalDateTime ngayHoanThanh;
    @Column(name = "chu_thich")
    private String chuThich;

    @ManyToOne
    @JoinColumn(name = "nhan_vien_sua_chua_id")
    private User nhanVienSuaChua;
    @ManyToOne
    @JoinColumn(name = "linh_kien_id")
    private LinhKien linhKien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "san_pham_id")
    private SanPham sanPham;

    @PostUpdate
    public void postUpdate() {
        this.ngayHoanThanh = LocalDateTime.now();
    }



}
