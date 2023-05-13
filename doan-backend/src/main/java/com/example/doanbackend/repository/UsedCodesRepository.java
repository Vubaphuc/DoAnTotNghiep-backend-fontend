package com.example.doanbackend.repository;

import com.example.doanbackend.entity.UsedCodes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsedCodesRepository extends JpaRepository<UsedCodes, Integer> {
    boolean existsByCode(String code);
}