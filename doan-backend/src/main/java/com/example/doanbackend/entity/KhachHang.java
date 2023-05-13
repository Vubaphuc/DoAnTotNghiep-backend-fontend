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
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "Ma_Khach_Hang", unique = true)
    private String maKhachHang;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "So_Dien_Thoai")
    private String phoneNumber;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "Dia_Chi")
    private String address;

    @OneToMany(mappedBy = "khachHang", orphanRemoval = true)
    private List<SanPham> sanPhams = new ArrayList<>();



}