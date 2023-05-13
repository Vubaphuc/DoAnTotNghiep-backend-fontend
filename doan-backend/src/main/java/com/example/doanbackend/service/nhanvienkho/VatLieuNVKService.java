package com.example.doanbackend.service.nhanvienkho;

import com.example.doanbackend.dto.DanhSachVatLieuDto;
import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.dto.LinhKienDto;
import com.example.doanbackend.dto.page.PageDanhSachVatLieuDto;
import com.example.doanbackend.dto.page.PageLinhKienNVK;
import com.example.doanbackend.dto.page.PageVenderNVK;
import com.example.doanbackend.entity.LinhKien;
import com.example.doanbackend.entity.VatLieu;
import com.example.doanbackend.entity.Vendor;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.request.TaoMoiLoaiLinhKien;
import com.example.doanbackend.request.TaoVatLieuMoi;
import com.example.doanbackend.service.jpaservice.EntityLinhKienService;
import com.example.doanbackend.service.jpaservice.EntityVatLieuService;
import com.example.doanbackend.service.jpaservice.EntityVenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VatLieuNVKService {
    @Autowired
    private EntityLinhKienService entityLinhKienService;
    @Autowired
    private EntityVenderService entityVenderService;
    @Autowired
    private EntityVatLieuService entityVatLieuService;


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

    public LinhKien taoMoiLoaiLinhKien(TaoMoiLoaiLinhKien taoMoiLoaiLinhKien) {

        if (entityLinhKienService.kiemTraTenLinhKien(taoMoiLoaiLinhKien.getName()).isPresent()) {
            throw new BadRequestException("Loại Linh kiện đã tồn tại");
        }

        LinhKien linhKien = LinhKien.builder()
                .name(taoMoiLoaiLinhKien.getName())
                .thoiGianBaoHanh(taoMoiLoaiLinhKien.getThoiGianBaoHanh())
                .build();

        entityLinhKienService.save(linhKien);

        return linhKien;
    }

    // tạo mới vật liệu
    public String taoMoiVatLieu(TaoVatLieuMoi taoVatLieuMoi) {

        if (entityVatLieuService.kiemTraCodeVatLieu(taoVatLieuMoi.getMaVatLieu()).isPresent()) {

            VatLieu vatLieu = entityVatLieuService.kiemTraCodeVatLieu(taoVatLieuMoi.getMaVatLieu()).get();
            vatLieu.setSoLuong(vatLieu.getSoLuong() + taoVatLieuMoi.getSoLuong());

            entityVatLieuService.save(vatLieu);

            return "Cập nhật thành công";
        }

        LinhKien linhKien = entityLinhKienService.findById(taoVatLieuMoi.getLoaiLinhKienId());

        Vendor vendor = entityVenderService.layVenderRaTheoId(taoVatLieuMoi.getVenderId());

        VatLieu vatLieu = VatLieu.builder()
                .code(taoVatLieuMoi.getMaVatLieu())
                .tenModel(taoVatLieuMoi.getTenModel())
                .soLuong(taoVatLieuMoi.getSoLuong())
                .linhKien(linhKien)
                .vendors(List.of(vendor))
                .build();

        entityVatLieuService.save(vatLieu);

        return "Đăng Ký Thành công";
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
}
