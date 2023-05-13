package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.dto.DanhSachVatLieuDto;
import com.example.doanbackend.dto.DanhSachVatLieuTheoVendorDto;
import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.dto.VatLieuSuaChuaDto;
import com.example.doanbackend.entity.VatLieu;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.VatLieuRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IVatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityVatLieuService implements IVatLieuService {
    @Autowired
    private VatLieuRepository vatLieuRepository;
    @Override
    public void save(VatLieu vatLieu) {
        vatLieuRepository.save(vatLieu);
    }

    @Override
    public Page<DanhSachVenderDto> danhSachTongVatLieuTungVender(int page, int pageSize) {
        return vatLieuRepository.danhSachVenderCoTongSoVatLieuDangCo(PageRequest.of(page  - 1, pageSize));
    }

    @Override
    public Optional<VatLieu> kiemTraCodeVatLieu(String code) {
        return vatLieuRepository.findByCode(code);
    }

    @Override
    public Page<DanhSachVatLieuDto> danhSachVatLieuAll(int page, int pageSize) {
        return vatLieuRepository.danhSachVatLieuAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<DanhSachVatLieuTheoVendorDto> danhSachVatLieuTheoVendor(int page, int pageSize, int vendorId) {
        return vatLieuRepository.danhSachVatLieuTheoVendor(PageRequest.of(page - 1, pageSize), vendorId);
    }

    @Override
    public VatLieuSuaChuaDto layVatLieuTheoCode(String code) {
        return vatLieuRepository.layVatLieuTheoCode(code).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy vật liệu nào có code là " + code);
        });
    }

    @Override
    public VatLieu findByCode(String code) {
        return vatLieuRepository.findByCode(code).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy Vật liệu có Code là " + code);
        });
    }

    @Override
    public List<VatLieuSuaChuaDto> danhSachVatLieuTheoModelVaLinhKien(String tenModel, String tenLinhKien) {
        return vatLieuRepository.danhSachVatLieuTheoModelVaLinhKien(tenModel,tenLinhKien);
    }
}
