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
@Table(name = "thong_tin_le_tan")
public class ThongTinLeTan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "ngay_nhan_san_pham")
    private LocalDateTime ngayNhanSanPham;
    @Column(name = "ngay_chuyen")
    private LocalDateTime ngayChuyen;
    @ManyToOne
    @JoinColumn(name = "nhan_vien_le_tan_id")
    private User nhanVienLeTan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "san_pham_id")
    private SanPham sanPham;

    @PrePersist
    public void prePersist () {
        this.ngayNhanSanPham = LocalDateTime.now();
    }


}
