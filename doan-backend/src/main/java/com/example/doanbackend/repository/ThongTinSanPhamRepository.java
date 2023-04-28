package com.example.doanbackend.repository;

import com.example.doanbackend.entity.ThongTinSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ThongTinSanPhamRepository extends JpaRepository<ThongTinSanPham, Integer> {

    Optional<ThongTinSanPham> findById(Integer id);
}