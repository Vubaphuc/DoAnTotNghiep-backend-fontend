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
@Table(name = "linh_kien")
public class LinhKien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "thoi_gian_bao_hanh")
    private Integer thoiGianBaoHanh;

    @OneToMany(mappedBy = "linhKien", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VatLieu> vatLieus = new ArrayList<>();

}