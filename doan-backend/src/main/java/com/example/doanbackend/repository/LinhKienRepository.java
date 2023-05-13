package com.example.doanbackend.repository;

import com.example.doanbackend.dto.LinhKienDto;
import com.example.doanbackend.entity.LinhKien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LinhKienRepository extends JpaRepository<LinhKien, Integer> {

    Optional<LinhKien> findById(Integer id);
    Optional<LinhKien> findByName(String name);

    @Query("select new com.example.doanbackend.dto.LinhKienDto(l.id,l.name,l.thoiGianBaoHanh) from LinhKien l")
    Page<LinhKienDto> layDanhSachLinhKienCoPhanTrang(Pageable pageable);
}