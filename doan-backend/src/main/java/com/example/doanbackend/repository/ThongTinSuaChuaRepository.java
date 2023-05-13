package com.example.doanbackend.repository;

import com.example.doanbackend.entity.ThongTinSuaChua;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ThongTinSuaChuaRepository extends JpaRepository<ThongTinSuaChua, Integer> {

    Optional<ThongTinSuaChua> findById(Integer id);
}