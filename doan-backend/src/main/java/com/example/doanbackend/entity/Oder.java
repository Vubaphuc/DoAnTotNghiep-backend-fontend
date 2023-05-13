package com.example.doanbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "oder")
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "Ma_Oder")
    private String maOder;
    @Column(name = "So_Luong")
    private int soLuong;
    @Column(name = "Trang_Thai")
    private boolean isStatus = false;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhan_vien_oder_id")
    private User nhanVienOder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhan_vien_phe_duyet_id")
    private User nhanVienPheDuyet;



    @ManyToMany
    @JoinTable(name = "oder_vat_lieus",
            joinColumns = @JoinColumn(name = "oder_id"),
            inverseJoinColumns = @JoinColumn(name = "vat_lieus_id"))
    private List<VatLieu> vatLieus = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linh_kien_id")
    private LinhKien linhKien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

}