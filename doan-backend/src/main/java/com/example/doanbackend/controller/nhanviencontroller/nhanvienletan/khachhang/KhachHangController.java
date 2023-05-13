package com.example.doanbackend.controller.nhanviencontroller.nhanvienletan.khachhang;

import com.example.doanbackend.request.KhachHangDangKyMoi;
import com.example.doanbackend.service.nhanvienletanservice.khachhang.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("le-tan/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("san-pham-ok")
    public ResponseEntity<?> danhSachKhachHangCoSanPhamOk(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(khachHangService.danhSachKhachHangCoSanPhamOk(page,pageSize));
    }

    @GetMapping("san-pham-pending")
    public ResponseEntity<?> danhSachKhachHangCoSanPhamPeding(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(khachHangService.danhSachKhachHangCoSanPhamPeding(page,pageSize));
    }



}
