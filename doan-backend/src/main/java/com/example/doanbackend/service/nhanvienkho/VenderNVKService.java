package com.example.doanbackend.service.nhanvienkho;

import com.example.doanbackend.dto.DanhSachVatLieuTheoVendorDto;
import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.dto.page.PageDanhSachKhachHangCoSanPham;
import com.example.doanbackend.dto.page.PageDanhSachVatLieuTheoVendorDto;
import com.example.doanbackend.dto.page.PageDanhSachVendorCoVatLieu;
import com.example.doanbackend.dto.page.PageVenderNVK;
import com.example.doanbackend.entity.Vendor;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.repository.VatLieuRepository;
import com.example.doanbackend.request.TaoMoiVender;
import com.example.doanbackend.service.jpaservice.EntityVatLieuService;
import com.example.doanbackend.service.jpaservice.EntityVenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VenderNVKService {
    @Autowired
    private EntityVenderService entityVenderService;
    @Autowired
    private EntityVatLieuService entityVatLieuService;

    // lấy danh sách vender có phân trang
    public PageVenderNVK danhSachTatCaVender(int page, int pageSize) {
        Page<Vendor> vendorPage = entityVenderService.danhSachTatCaVender(page, pageSize);
        return new PageVenderNVK(
                vendorPage.getNumber() + 1,
                vendorPage.getSize(),
                vendorPage.getTotalPages(),
                (int) Math.ceil(vendorPage.getTotalElements()),
                vendorPage.getContent()
        );
    }

    // tạo mới 1 vender
    public Vendor themVenderMoi(TaoMoiVender taoMoiVender) {

        if (entityVenderService.kiemTraTenVendor(taoMoiVender.getName()).isPresent()) {
            throw new BadRequestException("Tên vendor đã tồn tại");
        }

        Vendor vendor = Vendor.builder()
                .name(taoMoiVender.getName())
                .build();

        entityVenderService.save(vendor);

        return vendor;
    }


    public Vendor layVenderRaTheoId(Integer id) {
        return entityVenderService.layVenderRaTheoId(id);
    }

    public Vendor layVenderRaTheoTen(String name) {
        return entityVenderService.layVenderRaTheoTen(name);
    }

    public Vendor suaTenVender(TaoMoiVender taoMoiVender, Integer id) {

        if (entityVenderService.kiemTraTenVendor(taoMoiVender.getName()).isPresent()) {
            throw new BadRequestException("Tên vendor đã tồn tại");
        }

        Vendor vendor = entityVenderService.layVenderRaTheoId(id);

        vendor.setName(taoMoiVender.getName());

        entityVenderService.save(vendor);

        return vendor;
    }

    public PageDanhSachVendorCoVatLieu danhSachVenderCoTongSoVatLieuDangCo(int page, int pageSize) {

        Page<DanhSachVenderDto> venderDtoPage = entityVatLieuService.danhSachTongVatLieuTungVender(page,pageSize);

        return new PageDanhSachVendorCoVatLieu(
                venderDtoPage.getNumber() + 1,
                venderDtoPage.getSize(),
                venderDtoPage.getTotalPages(),
                (int) Math.ceil(venderDtoPage.getTotalElements()),
                venderDtoPage.getContent()
        );
    }

    public PageDanhSachVatLieuTheoVendorDto danhSachVatLieuTheoVendor (int page, int pageSize, int vendorId) {
        Page<DanhSachVatLieuTheoVendorDto> vatLieuTheoVendorDtos = entityVatLieuService.danhSachVatLieuTheoVendor(page,pageSize,vendorId);

        return new PageDanhSachVatLieuTheoVendorDto(
                vatLieuTheoVendorDtos.getNumber() + 1,
                vatLieuTheoVendorDtos.getSize(),
                vatLieuTheoVendorDtos.getTotalPages(),
                (int) Math.ceil(vatLieuTheoVendorDtos.getTotalElements()),
                vatLieuTheoVendorDtos.getContent()
        );
    }




}
