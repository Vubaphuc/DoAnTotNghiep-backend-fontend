package com.example.doanbackend.service.nhanvienkho;

import com.example.doanbackend.dto.DanhSachVatLieuDto;
import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.dto.HistoryMaterialDto;
import com.example.doanbackend.dto.LinhKienDto;
import com.example.doanbackend.dto.page.*;
import com.example.doanbackend.entity.LinhKien;
import com.example.doanbackend.entity.VatLieu;
import com.example.doanbackend.entity.Vendor;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.request.TaoMoiLoaiLinhKien;
import com.example.doanbackend.request.TaoVatLieuMoi;
import com.example.doanbackend.response.StatusResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityLinhKienService;
import com.example.doanbackend.service.jpaservice.EntityVatLieuService;
import com.example.doanbackend.service.jpaservice.EntityVenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VatLieuNVKService {
    @Autowired
    private EntityLinhKienService entityLinhKienService;
    @Autowired
    private EntityVenderService entityVenderService;
    @Autowired
    private EntityVatLieuService entityVatLieuService;
    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;


    public PageLinhKienNVK danhSachLinhKien(int page, int pageSize) {

        Page<LinhKienDto> linhKienPage =  entityLinhKienService.danhSachLinhKien(page,pageSize);

        return new PageLinhKienNVK(
                linhKienPage.getNumber() + 1,
                linhKienPage.getSize(),
                linhKienPage.getTotalPages(),
                (int) Math.ceil(linhKienPage.getTotalElements()),
                linhKienPage.getContent()
        );
    }

    public StatusResponse taoMoiLoaiLinhKien(TaoMoiLoaiLinhKien taoMoiLoaiLinhKien) {

        if (entityLinhKienService.kiemTraTenLinhKien(taoMoiLoaiLinhKien.getName()).isPresent()) {
            throw new BadRequestException("Loại Linh kiện đã tồn tại");
        }

        LinhKien linhKien = LinhKien.builder()
                .name(taoMoiLoaiLinhKien.getName())
                .thoiGianBaoHanh(taoMoiLoaiLinhKien.getThoiGianBaoHanh())
                .nhanVienNhap(iCurrentUserLmpl.getUser())
                .build();

        entityLinhKienService.save(linhKien);

        return new StatusResponse(200,"Đăng Ký Thành Công");
    }

    // tạo mới vật liệu
    public StatusResponse taoMoiVatLieu(TaoVatLieuMoi taoVatLieuMoi) {

        if (entityVatLieuService.kiemTraCodeVatLieu(taoVatLieuMoi.getMaVatLieu()).isPresent()) {

            VatLieu vatLieu = entityVatLieuService.kiemTraCodeVatLieu(taoVatLieuMoi.getMaVatLieu()).get();
            vatLieu.setSoLuong(vatLieu.getSoLuong() + taoVatLieuMoi.getSoLuong());

            entityVatLieuService.save(vatLieu);

            return new StatusResponse(200,"Cập Nhật Thành Công");
        }

        LinhKien linhKien = entityLinhKienService.findById(taoVatLieuMoi.getLoaiLinhKienId());

        Vendor vendor = entityVenderService.findById(taoVatLieuMoi.getVenderId());

        VatLieu vatLieu = VatLieu.builder()
                .code(taoVatLieuMoi.getMaVatLieu())
                .tenModel(taoVatLieuMoi.getTenModel())
                .soLuong(taoVatLieuMoi.getSoLuong())
                .linhKien(linhKien)
                .vendor(vendor)
                .nhanVienNhap(iCurrentUserLmpl.getUser())
                .build();

        entityVatLieuService.save(vatLieu);

        return new StatusResponse(200,"Đăng Ký Thành Công");
    }

    public PageDanhSachVatLieuDto danhSachVatLieuAll(int page, int pageSize) {

        Page<DanhSachVatLieuDto> vatLieuDtoPage = entityVatLieuService.danhSachVatLieuAll(page,pageSize);

       return new PageDanhSachVatLieuDto(
               vatLieuDtoPage.getNumber() + 1,
               vatLieuDtoPage.getSize(),
               vatLieuDtoPage.getTotalPages(),
               (int) Math.ceil(vatLieuDtoPage.getTotalElements()),
               vatLieuDtoPage.getContent()
       );
    }

    public PageHistoryMaterial searchHistoryMaterial(int page, int pageSize, String term) {

        if (term == null || term.trim().isEmpty()) {
            return new PageHistoryMaterial(
                    0,0,0,0,new ArrayList<>()
            );
        }

        Page<HistoryMaterialDto> materialDtos = entityVatLieuService.searchHistoryMaterial(page,pageSize,term);

        return new PageHistoryMaterial(
                materialDtos.getNumber() + 1,
                materialDtos.getSize(),
                materialDtos.getTotalPages(),
                (int) Math.ceil(materialDtos.getTotalElements()),
                materialDtos.getContent()
        );
    }
}
