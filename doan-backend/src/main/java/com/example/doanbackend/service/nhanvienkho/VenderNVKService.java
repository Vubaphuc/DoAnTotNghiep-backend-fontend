package com.example.doanbackend.service.nhanvienkho;

import com.example.doanbackend.dto.DanhSachVatLieuTheoVendorDto;
import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.dto.VendorDto;
import com.example.doanbackend.dto.page.PageDanhSachKhachHangCoSanPham;
import com.example.doanbackend.dto.page.PageDanhSachVatLieuTheoVendorDto;
import com.example.doanbackend.dto.page.PageDanhSachVendorCoVatLieu;
import com.example.doanbackend.dto.page.PageVenderNVK;
import com.example.doanbackend.entity.Vendor;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.repository.VatLieuRepository;
import com.example.doanbackend.request.TaoMoiVender;
import com.example.doanbackend.response.StatusResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityVatLieuService;
import com.example.doanbackend.service.jpaservice.EntityVenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class VenderNVKService {
    @Autowired
    private EntityVenderService entityVenderService;
    @Autowired
    private EntityVatLieuService entityVatLieuService;
    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;

    // lấy danh sách vender có phân trang
    public PageVenderNVK danhSachTatCaVender(int page, int pageSize) {
        Page<VendorDto> vendorPage = entityVenderService.danhSachTatCaVender(page, pageSize);
        return new PageVenderNVK(
                vendorPage.getNumber() + 1,
                vendorPage.getSize(),
                vendorPage.getTotalPages(),
                (int) Math.ceil(vendorPage.getTotalElements()),
                vendorPage.getContent()
        );
    }

    // tạo mới 1 vender
    public StatusResponse themVenderMoi(TaoMoiVender taoMoiVender) {

        if (entityVenderService.kiemTraTenVendor(taoMoiVender.getName()).isPresent()) {
            throw new BadRequestException("Tên vendor đã tồn tại");
        }

        Vendor vendor = Vendor.builder()
                .name(taoMoiVender.getName())
                .nhanVienNhap(iCurrentUserLmpl.getUser())
                .build();

        entityVenderService.save(vendor);

        return new StatusResponse(200,"Thêm Vender Thành Công");
    }


    public VendorDto layVenderRaTheoId(Integer id) {
        return entityVenderService.layVenderRaTheoId(id);
    }

    public VendorDto layVenderRaTheoTen(String name) {
        return entityVenderService.layVenderRaTheoTen(name);
    }

    public StatusResponse suaTenVender(TaoMoiVender taoMoiVender, Integer id) {

        if (entityVenderService.kiemTraTenVendor(taoMoiVender.getName()).isPresent()) {
            throw new BadRequestException("Tên vendor đã tồn tại");
        }

        Vendor vendor = entityVenderService.findById(id);

        vendor.setName(taoMoiVender.getName());
        vendor.setNhanVienNhap(iCurrentUserLmpl.getUser());

        entityVenderService.save(vendor);

        return new StatusResponse(200,"Thêm Vender Thành Công");
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
