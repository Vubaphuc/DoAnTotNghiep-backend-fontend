package com.example.doanbackend.repository;

import com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT;
import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.dto.VendorDto;
import com.example.doanbackend.entity.Vendor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    Optional<Vendor> findById(Integer id);
    Optional<Vendor> findByName(String name);


    @Query("select new com.example.doanbackend.dto.VendorDto(v.id, v.name) from Vendor v ")
    Page<VendorDto> danhSachTatCaVender(Pageable pageable);

    @Query("select new com.example.doanbackend.dto.VendorDto (v.id, v.name) " +
            "from Vendor v " +
            "where v.id =?1 ")
    VendorDto layVenderRaTheoId(Integer id);
    @Query("select new com.example.doanbackend.dto.VendorDto (v.id, v.name) " +
            "from Vendor v " +
            "where v.name =?1 ")
    VendorDto layVenderRaTheoTen(String name);
}