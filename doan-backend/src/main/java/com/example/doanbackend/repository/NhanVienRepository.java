package com.example.doanbackend.repository;

import com.example.doanbackend.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    Optional<NhanVien> findNhanVienById(Integer id);
    Optional<NhanVien> findNhanVienByMaNhanVien(String maNhanVien);
    Optional<NhanVien> findNhanVienByEmail(String email);
}