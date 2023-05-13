package com.example.doanbackend.repository;

import com.example.doanbackend.entity.LoaiNhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoaiNhanVienRepository extends JpaRepository<LoaiNhanVien, Integer> {

    Optional<LoaiNhanVien> findByName(String name);
}