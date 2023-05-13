package com.example.doanbackend.controller.nhanviencontroller.nhanvienletan;

import com.example.doanbackend.request.DangKyKhachHangSanPhamMoi;
import com.example.doanbackend.service.nhanvienletanservice.DangKyKhachHangSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dang-ky")
public class DangKyKhachHangSanPhamController {
    @Autowired
    private DangKyKhachHangSanPhamService dangKyKhachHangSanPhamService;

    @PostMapping("new")
    public ResponseEntity<?> dangKyKhachHangSanPHamMoi (@RequestBody DangKyKhachHangSanPhamMoi dangKyKhachHangSanPhamMoi) {
        return ResponseEntity.ok(dangKyKhachHangSanPhamService.dangKyKhachHangSanPHamMoi(dangKyKhachHangSanPhamMoi));
    }

}
