package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.entity.Vendor;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IVenderService {

    void save (Vendor vendor);
    Page<Vendor> danhSachTatCaVender(int page, int pageSize);
    Vendor layVenderRaTheoId(Integer id);
    Vendor layVenderRaTheoTen(String name);
    Optional<Vendor> kiemTraTenVendor (String name);

}
