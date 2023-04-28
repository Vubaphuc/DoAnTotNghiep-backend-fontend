package com.example.doanbackend.service.nhanvienservice;

import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.request.TaoMoiKhachHangSanPham;
import com.example.doanbackend.service.interfaceservice.INhanVienLeTanService;
import org.springframework.stereotype.Service;

@Service
public class NhanVienLeTanService implements INhanVienLeTanService {
    @Override
    public SanPham taoMoiKhachHang(TaoMoiKhachHangSanPham taoMoiKhachHangSanPham) {
        SanPham sanPham = SanPham.builder().build();
        KhachHang khachHang = KhachHang.builder().build();
        return null;
    }
}
