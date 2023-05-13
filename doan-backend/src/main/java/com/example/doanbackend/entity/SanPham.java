package com.example.doanbackend.entity;

import com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT;
import com.example.doanbackend.dto.SanPhamChuaSuaDto;
import jakarta.persistence.*;
import lombok.*;




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
    @Column(name = "model")
    private String model;
    @Column(name = "hang_san_xuat")
    private String hangSanXuat;
    @Column(name = "ime")
    private String IME;
    @Column(name = "ten_loi")
    private String tenLoi;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "gia_tien")
    private double giaTien;
    @Column(name = "thanh_tien")
    private double thanhTien;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hoa_don_id")
    private HoaDon hoaDon;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thong_tin_sua_chua_id")
    private ThongTinSuaChua thongTinSuaChua;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thong_tin_le_tan_id")
    private ThongTinLeTan thongTinLeTan;

    @PrePersist
    public void prePersist() {
        this.trangThai = "PENDING";
    }



}