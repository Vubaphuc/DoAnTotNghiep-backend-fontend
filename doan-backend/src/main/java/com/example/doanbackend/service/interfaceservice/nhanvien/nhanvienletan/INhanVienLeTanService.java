package com.example.doanbackend.service.interfaceservice.nhanvien.nhanvienletan;

import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.request.TaoMoiKhachHangSanPham;

public interface INhanVienLeTanService {

    SanPham taoMoiKhachHang(TaoMoiKhachHangSanPham taoMoiKhachHangSanPham);

}
