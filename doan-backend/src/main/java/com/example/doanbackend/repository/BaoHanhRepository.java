package com.example.doanbackend.repository;

import com.example.doanbackend.entity.BaoHanh;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaoHanhRepository extends JpaRepository<BaoHanh, Integer> {

    Optional<BaoHanh> findBaoHanhById(Integer id);
    Optional<BaoHanh> findBaoHanhByMaSoBaoHanh(String maSoBaoHanh);
}