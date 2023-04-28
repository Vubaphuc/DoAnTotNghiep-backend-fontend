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
@Table(name = "bao_hanh")
public class BaoHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "Mã_Số_Bảo_Hành")
    private String maSoBaoHanh;
    @Column(name = "Tên_Loại_Bảo_Hành")
    private String tenLoaiBaoHanh;
    @Column(name = "Thời_Gian_Bảo_Hành")
    private Integer thoiGianBaoHanh;
    private boolean trangThai;
    @Column(name = "Ngày_Kích_Hoạt_Bảo_Hành")
    private LocalDateTime ngayKichHoatBaoHanh;

    @ManyToOne
    @JoinColumn(name = "san_pham_id")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "nhan_vien_id")
    private NhanVien nhanVienDangKy;

    @PrePersist
    public void prePersist() {
        if (this.trangThai) {
            this.ngayKichHoatBaoHanh = LocalDateTime.now();
        }

    }

}