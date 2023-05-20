package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.dto.VendorDto;
import com.example.doanbackend.entity.Vendor;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IVenderService {

    void save (Vendor vendor);
    Page<VendorDto> danhSachTatCaVender(int page, int pageSize);

    Optional<Vendor> kiemTraTenVendor (String name);
    Vendor findById(Integer id);
    VendorDto layVenderRaTheoId(Integer id);
    VendorDto layVenderRaTheoTen(String name);

}
