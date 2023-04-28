package com.example.doanbackend.repository;

import com.example.doanbackend.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    Optional<SanPham> findById(Integer id);
    Optional<SanPham> findByIME(String IME);

    @Query("select s from SanPham s where upper(s.IME) = upper(?1)")
    Optional<SanPham> getSanPhamById(String IME);


}