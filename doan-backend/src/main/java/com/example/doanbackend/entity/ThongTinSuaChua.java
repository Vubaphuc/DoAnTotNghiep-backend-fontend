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
    @Column(name = "vi_tri_sua")
    private String viTriSua;
    @Column(name = "chu_thich")
    private String chuThich;
    @ManyToOne
    @JoinColumn(name = "nhan_vien_sua_chua_id")
    private User nhanVienSuaChua;

    @PostUpdate
    public void postUpdate() {
        this.ngayHoanThanh = LocalDateTime.now();
    }

    // null, nguyên nhân lỗi, null, vị trí sửa, chú thích, nhân viên sửa.

}
