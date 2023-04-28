package com.example.doanbackend.repository;

import com.example.doanbackend.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

    Optional<HoaDon> findHoaDonById(Integer id);
    Optional<HoaDon> findHoaDonByMaHoaDon(String maHoaDon);
}