package com.example.doanbackend.service.nhanvienletanservice;

import com.example.doanbackend.config.GenerateCode;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.entity.ThongTinLeTan;
import com.example.doanbackend.entity.User;
import com.example.doanbackend.request.DangKyKhachHangSanPhamMoi;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityKhachHangService;
import com.example.doanbackend.service.jpaservice.EntitySanPhamService;
import com.example.doanbackend.service.jpaservice.EntityThongTinLeTan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DangKyKhachHangSanPhamService {
    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;
    @Autowired
    private GenerateCode generateCode;

    @Autowired
    private EntitySanPhamService entitySanPhamService;
    @Autowired
    private EntityKhachHangService entityKhachHangService;
    @Autowired
    private EntityThongTinLeTan entityThongTinLeTan;

    public String dangKyKhachHangSanPHamMoi(DangKyKhachHangSanPhamMoi dangKyKhachHangSanPhamMoi) {
        // lấy ra thông tin user login
        User user = iCurrentUserLmpl.getUser();
        // lấy ra khách hàng c email response gửi
        Optional<KhachHang> khachHang = entityKhachHangService.layRaKhachHangTheoEmail(dangKyKhachHangSanPhamMoi.getEmailKH());
        // nếu tồn tại khách hàng => thêm sản phẩm
        if (khachHang.isPresent()) {
            // tạo thông tin lễ tân mới
            ThongTinLeTan thongTinLeTanNew = ThongTinLeTan.builder()
                    .nhanVienLeTan(user)
                    .build();
            // lưu lại thông tin lễ tân vào csdl
            entityThongTinLeTan.save(thongTinLeTanNew);
            // tạo thêm sản phẩm mới
            SanPham sanPham = taoSanPhamMoi(dangKyKhachHangSanPhamMoi,thongTinLeTanNew);
            // gán thêm khách hàng vào sản pham
            sanPham.setKhachHang(khachHang.get());
            // lưu sản phẩm vào csdl
            entitySanPhamService.save(sanPham);

            return "Đăng ký thành công";
        }

        // nếu không tìm thấy khách hàng trong csdl thì chuyển xuống đây
        // tạo mới thông tin lê tân
        ThongTinLeTan thongTinLeTan = ThongTinLeTan.builder()
                .nhanVienLeTan(user)
                .build();
        // lưu thông tin lễ tân vào csdl
        entityThongTinLeTan.save(thongTinLeTan);

        // tạo khách hàng mới
        KhachHang newKhachHang = taoKhachHangMoi(dangKyKhachHangSanPhamMoi);

        // tạo thông tin sản phẩm
        SanPham sanPham = taoSanPhamMoi(dangKyKhachHangSanPhamMoi,thongTinLeTan);
        // lưu sản phẩm vào list sản phẩm của khách
        newKhachHang.getSanPhams().add(sanPham);
        // lưu thông tin khách hàng vào csdl
        entityKhachHangService.save(newKhachHang);
        // thêm khách hàng vào sản phẩm
        sanPham.setKhachHang(newKhachHang);
        // lưu sản phẩm vào csdl
        entitySanPhamService.save(sanPham);


        return "Đăng Ký Thành công";
    }

    //tạo 1 khách hàng mới
    private KhachHang taoKhachHangMoi (DangKyKhachHangSanPhamMoi dangKyKhachHangSanPhamMoi) {
        List<SanPham> sanPhams = new ArrayList<>();

        KhachHang khachHang = KhachHang.builder()
                .maKhachHang(generateCode.generateCode())
                .fullName(dangKyKhachHangSanPhamMoi.getFullNameKH())
                .phoneNumber(dangKyKhachHangSanPhamMoi.getPhoneKH())
                .email(dangKyKhachHangSanPhamMoi.getEmailKH())
                .address(dangKyKhachHangSanPhamMoi.getAddressKH())
                .sanPhams(sanPhams)
                .build();

        entityKhachHangService.save(khachHang);

        return khachHang;
    }

    // tạo 1 sản phẩm mới
    private SanPham taoSanPhamMoi(DangKyKhachHangSanPhamMoi dangKyKhachHangSanPhamMoi,ThongTinLeTan thongTinLeTan) {

        SanPham sanPham = SanPham.builder()
                .hangSanXuat(dangKyKhachHangSanPhamMoi.getHangSanPham())
                .model(dangKyKhachHangSanPhamMoi.getModel())
                .IME(dangKyKhachHangSanPhamMoi.getSoIME())
                .giaTien(dangKyKhachHangSanPhamMoi.getGiaTien())
                .soLuong(dangKyKhachHangSanPhamMoi.getSoLuong())
                .thanhTien(dangKyKhachHangSanPhamMoi.getThanhTien())
                .tenLoi(dangKyKhachHangSanPhamMoi.getTenLoi())
                .thongTinLeTan(thongTinLeTan)
                .build();

        return sanPham;
    }

}
