package com.example.doanbackend.controller.nhanviencontroller.nhanvienletan.khachhang;

import com.example.doanbackend.request.TaoKhachHangMoi;
import com.example.doanbackend.request.TaoMoiHoaDon;
import com.example.doanbackend.service.nhanvienletanservice.khachhang.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("le-tan/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("san-pham/search-OK")
    public ResponseEntity<?> timKiemSanPhamTheoTenKhachHangOK(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(khachHangService.timKiemSanPhamTheoTenKhachHangOK(term,page,pageSize));
    }

    @GetMapping("san-pham/search-Pending")
    public ResponseEntity<?> timKiemSanPhamTheoTenKhachHangPending(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(khachHangService.timKiemSanPhamTheoTenKhachHangPending(page,pageSize,term));
    }

    @GetMapping("san-pham/{id}")
    public ResponseEntity<?> danhSachSanPhamTheoIdKKhachHang(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @PathVariable Integer id) {
        return ResponseEntity.ok(khachHangService.danhSachSanPhamTheoIdKKhachHang(id,page,pageSize));
    }
    @GetMapping("{id}")
    public ResponseEntity<?> khachHangTheoId(@PathVariable Integer id) {
        return ResponseEntity.ok(khachHangService.khachHangTheoId(id));
    }

    @PostMapping("dang-ky")
    public ResponseEntity<?> dangKyKhachHangSanPHamMoi (@RequestBody TaoKhachHangMoi taoKhachHangMoi) {
        return ResponseEntity.ok(khachHangService.dangKyKhachHangMoi(taoKhachHangMoi));
    }





}
