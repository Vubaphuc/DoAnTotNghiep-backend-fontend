package com.example.doanbackend.service.nhanvienbaohanh;

import com.example.doanbackend.dto.*;
import com.example.doanbackend.dto.page.PageHistoryProduct;
import com.example.doanbackend.dto.page.PageNhanVienDto;
import com.example.doanbackend.dto.page.PageSanPhamBaoHanh;
import com.example.doanbackend.entity.*;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.request.CapNhatThongTinNhanVienSuaChua;
import com.example.doanbackend.request.DangKyNhanVienSuaBaoHanh;
import com.example.doanbackend.request.ThongTinBaoHanhCoTinhPhi;
import com.example.doanbackend.request.ThongTinBaoHanhKhongTinhPhi;
import com.example.doanbackend.response.StatusResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntitySanPhamService;
import com.example.doanbackend.service.jpaservice.EntityThongTinBaoHanhService;
import com.example.doanbackend.service.jpaservice.EntityThongTinSuaChuaService;
import com.example.doanbackend.service.jpaservice.EntityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class NhanVienBaoHanhService {
    @Autowired
    private EntityUserService entityUserService;
    @Autowired
    private EntitySanPhamService entitySanPhamService;
    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;

    @Autowired
    private EntityThongTinBaoHanhService thongTinBaoHanhService;
    @Autowired
    private EntityThongTinSuaChuaService thongTinSuaChuaService;




    public PageNhanVienDto danhSachNhanVienSuaChuaCoPhanTrang(int page, int pageSize) {
        Page<NhanVienDto> nhanVienDtoPage = entityUserService.danhSachNhanVienSuaChuaCoPhanTrang(page, pageSize);
        return new PageNhanVienDto(
                nhanVienDtoPage.getNumber() + 1,
                nhanVienDtoPage.getSize(),
                nhanVienDtoPage.getTotalPages(),
                (int) Math.ceil(nhanVienDtoPage.getTotalElements()),
                nhanVienDtoPage.getContent()
        );
    }

    public PageHistoryProduct searchHistoryProductByTerm(int page, int pageSize, String term) {

        if (term == null || term.trim().isEmpty()) {
            return new PageHistoryProduct(
                    0,0,0,0,new ArrayList<>()
            );
        }

        Page<HistoryProductDto> productDtos = entitySanPhamService.searchHistoryProductByTerm(page,pageSize,term);
        return new PageHistoryProduct(
                productDtos.getNumber() + 1,
                productDtos.getSize(),
                productDtos.getTotalPages(),
                (int) Math.ceil(productDtos.getTotalElements()),
                productDtos.getContent()
        );
    }

    public ProductCustomerDto findProductAndCustomerById(Integer id) {
        return entitySanPhamService.findProductAndCustomerById(id);
    }

    public StatusResponse registerNewProductWarrantyMoney(ThongTinBaoHanhCoTinhPhi request) {

        SanPham sanPham = entitySanPhamService.findById(request.getId());

        ThongTinBaoHanh thongTinBaoHanh = ThongTinBaoHanh.builder()
                .sanPham(sanPham)
                .tenLoi(request.getTenLoi())
                .nguyenNhanGayLoi(request.getNguyenNhanLoi())
                .giaTien(request.getGiaTien())
                .LoaiBaoHanh(true)
                .nhanVienBaoHanh(iCurrentUserLmpl.getUser())
                .build();

        thongTinBaoHanhService.save(thongTinBaoHanh);

        return new  StatusResponse(200,"Thành Công");
    }

    public StatusResponse registerNewProductWarrantyNoMoney(ThongTinBaoHanhKhongTinhPhi request) {

        SanPham sanPham = entitySanPhamService.findById(request.getId());

        ThongTinBaoHanh thongTinBaoHanh = ThongTinBaoHanh.builder()
                .sanPham(sanPham)
                .tenLoi(request.getTenLoi())
                .nguyenNhanGayLoi(request.getNguyenNhanLoi())
                .nhanVienBaoHanh(iCurrentUserLmpl.getUser())
                .build();

        thongTinBaoHanhService.save(thongTinBaoHanh);

        return new  StatusResponse(200,"Thành Công");
    }

    public PageSanPhamBaoHanh danhSachSanPhamBaoHanhPending(int page, int pageSize, String term) {


        Page<SanPhamBaoHanhDto> sanPhamBaoHanhDtos = thongTinBaoHanhService.danhSachSanPhamBaoHanhPending(page,pageSize,term);

        return new PageSanPhamBaoHanh(
                sanPhamBaoHanhDtos.getNumber() + 1,
                sanPhamBaoHanhDtos.getSize(),
                sanPhamBaoHanhDtos.getTotalPages(),
                (int) Math.ceil(sanPhamBaoHanhDtos.getTotalElements()),
                sanPhamBaoHanhDtos.getContent()
        );
    }

    public PageSanPhamBaoHanh danhSachSanPhamBaoHanhOk(int page, int pageSize, String term) {


        Page<SanPhamBaoHanhDto> sanPhamBaoHanhDtos = thongTinBaoHanhService.danhSachSanPhamBaoHanhOk(page,pageSize,term);

        return new PageSanPhamBaoHanh(
                sanPhamBaoHanhDtos.getNumber() + 1,
                sanPhamBaoHanhDtos.getSize(),
                sanPhamBaoHanhDtos.getTotalPages(),
                (int) Math.ceil(sanPhamBaoHanhDtos.getTotalElements()),
                sanPhamBaoHanhDtos.getContent()
        );
    }

    public PageSanPhamBaoHanh danhSachSanPhamBaoHanhTatCa(int page, int pageSize, String term) {


        Page<SanPhamBaoHanhDto> sanPhamBaoHanhDtos = thongTinBaoHanhService.danhSachSanPhamBaoHanhTatCa(page,pageSize,term);

        return new PageSanPhamBaoHanh(
                sanPhamBaoHanhDtos.getNumber() + 1,
                sanPhamBaoHanhDtos.getSize(),
                sanPhamBaoHanhDtos.getTotalPages(),
                (int) Math.ceil(sanPhamBaoHanhDtos.getTotalElements()),
                sanPhamBaoHanhDtos.getContent()
        );
    }

    public BaoHanhDto sanPhamBaoHanhTheoId(Integer id) {
        return thongTinBaoHanhService.sanPhamBaoHanhTheoId(id);
    }

    public StatusResponse capNhatThongTinNhanVienSuaChua(DangKyNhanVienSuaBaoHanh dangKyNhanVienSuaBaoHanh, Integer id) {

        ThongTinBaoHanh thongTinBaoHanh = thongTinBaoHanhService.sanPhamFindById(id);

        SanPham sanPham = thongTinBaoHanh.getSanPham();

        User user = entityUserService.findByMaNhanVien(dangKyNhanVienSuaBaoHanh.getMaNhanVien());


        ThongTinSuaChua thongTinSuaChua = ThongTinSuaChua.builder()
                .sanPham(sanPham)
                .nhanVienSuaChua(user)
                .build();

        thongTinSuaChuaService.save(thongTinSuaChua);



        return new StatusResponse(200,"Đăng Ký Thành Công");
    }
}
