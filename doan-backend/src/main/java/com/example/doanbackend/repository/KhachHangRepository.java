package com.example.doanbackend.repository;

import com.example.doanbackend.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {

    Optional<KhachHang> findKhachHangById(Integer id);
    Optional<KhachHang> findByEmail(String email);
}