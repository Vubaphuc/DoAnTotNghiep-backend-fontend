package com.example.doanbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "thong_tin_san_pham")
public class ThongTinSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private LocalDateTime ngayChuyen;
    private LocalDateTime ngayHoanThanh;
    private String viTriSua;
    private String chuThich;

    @ManyToOne
    @JoinColumn(name = "nhan_vien_le_tan_id")
    private NhanVien nhanVienLeTan;

    @ManyToOne
    @JoinColumn(name = "nhan_vien_sua_chua_id")
    private NhanVien nhanVienSuaChua;

}