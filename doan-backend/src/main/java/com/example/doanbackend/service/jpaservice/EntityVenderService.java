package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.entity.Vendor;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.VendorRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IVenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityVenderService implements IVenderService {
    @Autowired
    private VendorRepository vendorRepository;
    @Override
    public void save(Vendor vendor) {
        vendorRepository.save(vendor);
    }
    @Override
    public Page<Vendor> danhSachTatCaVender(int page, int pageSize) {
        return vendorRepository.findAll(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Vendor layVenderRaTheoId(Integer id) {
        return vendorRepository.findById(id).orElseThrow(() -> {
           throw new NotFoundException("Không tìm thấy vender có id là " + id);
        });
    }
    @Override
    public Vendor layVenderRaTheoTen(String name) {
        return vendorRepository.findByName(name).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy vender có name là " + name);
        });
    }

    @Override
    public Optional<Vendor> kiemTraTenVendor (String name) {
        return vendorRepository.findByName(name);
    }

}
