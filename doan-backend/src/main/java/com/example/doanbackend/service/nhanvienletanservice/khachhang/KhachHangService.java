package com.example.doanbackend.service.nhanvienletanservice.khachhang;

import com.example.doanbackend.config.GenerateCode;
import com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT;
import com.example.doanbackend.dto.DanhSachSanPhamNVSCDto;
import com.example.doanbackend.dto.HistoryCustomerDto;
import com.example.doanbackend.dto.KhachHangDto;
import com.example.doanbackend.dto.page.PageDanhSachKhachHangCoSanPham;
import com.example.doanbackend.dto.page.PageDanhSachSanPhamNVSC;
import com.example.doanbackend.dto.page.PageHistoryCustomer;
import com.example.doanbackend.entity.*;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.mapper.KhachHangMapper;
import com.example.doanbackend.request.TaoKhachHangMoi;
import com.example.doanbackend.request.TaoMoiHoaDon;
import com.example.doanbackend.response.StatusResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {

    @Autowired
    private EntitySanPhamService entitySanPhamService;

    @Autowired
    private GenerateCode generateCode;

    @Autowired
    private EntityKhachHangService entityKhachHangService;


    // tìm kiếm san phẩm theo tên khách hang
    public PageDanhSachKhachHangCoSanPham timKiemSanPhamTheoTenKhachHangOK(String term,int page, int pageSize) {
        Page<DanhSachKhachHangCoSanPhamNVLT> sanPhamNVLTS = entitySanPhamService.timKiemSanPhamTheoTenKhachHangOK(term,page,pageSize);
        return new PageDanhSachKhachHangCoSanPham(
                sanPhamNVLTS.getNumber() + 1,
                sanPhamNVLTS.getSize(),
                sanPhamNVLTS.getTotalPages(),
                (int) Math.ceil(sanPhamNVLTS.getTotalElements()),
                sanPhamNVLTS.getContent()
        );
    }

    public PageHistoryCustomer timKiemSanPhamTheoTenKhachHangPending(int page, int pageSize, String term) {
        Page<HistoryCustomerDto> sanPhamNVLTS = entitySanPhamService.timKiemSanPhamTheoTenKhachHangPeding(page,pageSize, term);
        return new PageHistoryCustomer(
                sanPhamNVLTS.getNumber() + 1,
                sanPhamNVLTS.getSize(),
                sanPhamNVLTS.getTotalPages(),
                (int) Math.ceil(sanPhamNVLTS.getTotalElements()),
                sanPhamNVLTS.getContent()
        );
    }

    public PageDanhSachSanPhamNVSC danhSachSanPhamTheoIdKKhachHang(Integer id, int page, int pageSize) {
        Page<DanhSachSanPhamNVSCDto> sachSanPhamNVSCDtos = entitySanPhamService.danhSachSanPhamTheoIdKKhachHang(page,pageSize,id);
        return new PageDanhSachSanPhamNVSC(
                sachSanPhamNVSCDtos.getNumber() + 1,
                sachSanPhamNVSCDtos.getSize(),
                sachSanPhamNVSCDtos.getTotalPages(),
                (int) Math.ceil(sachSanPhamNVSCDtos.getTotalElements()),
                sachSanPhamNVSCDtos.getContent()
        );
    }

    public KhachHangDto dangKyKhachHangMoi(TaoKhachHangMoi taoKhachHangMoi) {

        // lấy ra khách hàng theo email response gửi
        Optional<KhachHang> khachHang = entityKhachHangService.layRaKhachHangTheoEmail(taoKhachHangMoi.getEmailKH());
        // nếu tồn tại khách hàng => thêm sản phẩm
        if (khachHang.isPresent()) {
            throw new BadRequestException("Khách Hàng đã tồn tại");
        }


        // tạo khách hàng mới
        KhachHang newKhachHang = KhachHang.builder()
                .maKhachHang(generateCode.generateCode())
                .fullName(taoKhachHangMoi.getFullNameKH())
                .phoneNumber(taoKhachHangMoi.getPhoneKH())
                .email(taoKhachHangMoi.getEmailKH())
                .address(taoKhachHangMoi.getAddressKH())
                .build();

        entityKhachHangService.save(newKhachHang);


        return KhachHangMapper.toKhachhangDto(newKhachHang);
    }

    public KhachHangDto khachHangTheoId(Integer id) {
        return KhachHangMapper.toKhachhangDto(entityKhachHangService.findById(id));
    }

}
