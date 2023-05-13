package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.LinhKienDto;
import com.example.doanbackend.entity.LinhKien;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ILinhKienService {
    void save(LinhKien linhKien);
    LinhKien findById(Integer id);
    LinhKien findByName(String name);

    Page<LinhKienDto> danhSachLinhKien(int page, int pageSize);
    Optional<LinhKien> kiemTraTenLinhKien (String name);
}
