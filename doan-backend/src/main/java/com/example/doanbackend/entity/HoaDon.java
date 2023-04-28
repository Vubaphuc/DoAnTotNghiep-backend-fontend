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
    @Column(name = "Mã_Hóa_Đơn")
    private String maHoaDon;
    @Column(name = "Số_Lượng")
    private Integer soLuong;
    @Column(name = "Giá_Tiền")
    private double giaTien;
    @Column(name = "Thành_Tiền")
    private double thanhTien;
    @Column(name = "Ngày_Bắt_Đầu_Bảo_Hành")
    private LocalDateTime ngayBatDauBaoHanh;
    @Column(name = "Ngày_Kết_Thúc_Bảo_Hành")
    private LocalDateTime ngayKetThucBaoHanh;
    @Column(name = "Ngày_Tạo_Hóa_Đơn")
    private LocalDateTime ngayTaoHoaDon;



    @ManyToOne
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "bao_hanh_id")
    private BaoHanh baoHanh;

    @OneToMany(mappedBy = "hoaDon", orphanRemoval = true)
    private List<SanPham> sanPhams = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.ngayTaoHoaDon = LocalDateTime.now();
        this.ngayBatDauBaoHanh = baoHanh.getNgayKichHoatBaoHanh();
        this.ngayKetThucBaoHanh = ngayBatDauBaoHanh.plusDays(baoHanh.getThoiGianBaoHanh());
    }

}