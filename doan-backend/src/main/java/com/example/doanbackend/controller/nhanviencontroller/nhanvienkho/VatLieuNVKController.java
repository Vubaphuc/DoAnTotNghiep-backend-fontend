package com.example.doanbackend.controller.nhanviencontroller.nhanvienkho;

import com.example.doanbackend.request.TaoMoiLoaiLinhKien;
import com.example.doanbackend.request.TaoVatLieuMoi;
import com.example.doanbackend.service.nhanvienkho.VatLieuNVKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nhan-vien-kho/vat-lieu")
public class VatLieuNVKController {
    @Autowired
    private VatLieuNVKService vatLieuNVKService;

    @GetMapping("linh-kien/danh-sach")
    public ResponseEntity<?> danhSachLinhKien(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(vatLieuNVKService.danhSachLinhKien(page,pageSize));
    }

    @PostMapping("linh-kien/tao-moi")
    public ResponseEntity<?> taoMoiLoaiLinhKien (@RequestBody TaoMoiLoaiLinhKien taoMoiLoaiLinhKien) {
        return ResponseEntity.ok(vatLieuNVKService.taoMoiLoaiLinhKien(taoMoiLoaiLinhKien));
    }

    @PostMapping("tao-moi")
    public ResponseEntity<?> taoMoiVatLieu (@RequestBody TaoVatLieuMoi taoVatLieuMoi) {
        return ResponseEntity.ok(vatLieuNVKService.taoMoiVatLieu(taoVatLieuMoi));
    }


    @PreAuthorize("hasAnyRole('ROLE_NHANVIENKHO', 'ROLE_NHANVIENSUACHUA')")
    @GetMapping("danh-sach")
    public ResponseEntity<?> danhSachVatLieuAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(vatLieuNVKService.danhSachVatLieuAll(page,pageSize));
    }
}
