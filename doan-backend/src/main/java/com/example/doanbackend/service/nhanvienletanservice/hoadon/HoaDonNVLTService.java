package com.example.doanbackend.service.nhanvienletanservice.hoadon;

import com.example.doanbackend.config.GenerateCode;
import com.example.doanbackend.dto.HoaDonSanPhamDto;
import com.example.doanbackend.entity.*;
import com.example.doanbackend.request.TaoMoiHoaDon;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityBaoHanhService;
import com.example.doanbackend.service.jpaservice.EntityHoaDonService;
import com.example.doanbackend.service.jpaservice.EntitySanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonNVLTService {
    @Autowired
    private EntitySanPhamService entitySanPhamService;

    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;
    @Autowired
    private GenerateCode generateCode;
    @Autowired
    private EntityBaoHanhService entityBaoHanhService;

    @Autowired
    private EntityHoaDonService entityHoaDonService;


    public HoaDonSanPhamDto layChiTietSanPhamOKTheoID(Integer id) {
        return entitySanPhamService.layChiTietSanPhamOKTheoID(id);
    }

    public BaoHanh taoHoaDonMoi(TaoMoiHoaDon taoMoiHoaDon) {
        // lấy ra sản phẩm
        SanPham sanPham = entitySanPhamService.findById(taoMoiHoaDon.getId());
        // lấy ra linh kiện theo sản phẩm
        LinhKien linhKien = sanPham.getThongTinSuaChua().getLinhKien();
        // lấy ra khách hàng theo sản phẩm
        KhachHang khachHang = sanPham.getKhachHang();
        // lấy ra tài khoản đang login
        User user = iCurrentUserLmpl.getUser();
        // tạo hóa đơn
        HoaDon hoaDon = HoaDon.builder()
                .maHoaDon(generateCode.generateCode())
                .soLuong(sanPham.getSoLuong())
                .thanhTien(sanPham.getThanhTien())
                .khachHang(khachHang)
                .sanPhams(List.of(sanPham))
                .nguoiTaoHoaDon(user)
                .build();
        // lưu hóa đơn lên csdl
        entityHoaDonService.save(hoaDon);
        //lưu lại hóa đơn vào sản phẩm
        sanPham.setHoaDon(hoaDon);
        // lưu lại lên csdl
        entitySanPhamService.save(sanPham);
        // tạo bảo hành
        BaoHanh baoHanh = BaoHanh.builder()
                .maSoBaoHanh(generateCode.generateCode())
                .linhKien(linhKien)
                .khachHang(khachHang)
                .sanPham(sanPham)
                .nguoiKichHoatBaoHanh(user)
                .build();
        // lưu bảo hành vào csdl
        entityBaoHanhService.save(baoHanh);


        return baoHanh;
    }
}
