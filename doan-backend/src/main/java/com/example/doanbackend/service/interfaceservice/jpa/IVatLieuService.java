package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.*;
import com.example.doanbackend.entity.VatLieu;
import com.example.doanbackend.entity.Vendor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IVatLieuService {
    void save (VatLieu vatLieu);
    Page<DanhSachVenderDto> danhSachTongVatLieuTungVender(int page, int pageSize);
    Optional<VatLieu> kiemTraCodeVatLieu (String code);
    Page<DanhSachVatLieuDto> danhSachVatLieuAll(int page, int pageSize);
    Page<DanhSachVatLieuTheoVendorDto> danhSachVatLieuTheoVendor(int page, int pageSize,int vendorId);
    VatLieuSuaChuaDto layVatLieuTheoCode(String code);

    VatLieu findByCode(String code);

    List<VatLieuSuaChuaDto> danhSachVatLieuTheoModelVaLinhKien(String tenModel, String tenLinhKien);
    Page<HistoryMaterialDto> searchHistoryMaterial(int page, int pageSize, String term);
}
