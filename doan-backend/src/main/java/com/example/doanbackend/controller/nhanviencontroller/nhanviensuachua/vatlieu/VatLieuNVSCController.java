package com.example.doanbackend.controller.nhanviencontroller.nhanviensuachua.vatlieu;

import com.example.doanbackend.request.TaoOrderVatLieu;
import com.example.doanbackend.service.nhanviensuachua.VatLieuNVSCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nhan-vien-sua-chua/vat-lieu")
public class VatLieuNVSCController {
    @Autowired
    private VatLieuNVSCService vatLieuNVSCService;

    @GetMapping("danh-sach")
    public ResponseEntity<?> danhSachVatLieuConHang(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(vatLieuNVSCService.danhSachVatLieuConHang(page,pageSize));
    }

    @GetMapping("chi-tiet/{code}")
    public ResponseEntity<?> layVatLieuTheoCode(@PathVariable String code) {
        return ResponseEntity.ok(vatLieuNVSCService.layVatLieuTheoCode(code));
    }

    @PostMapping("order")
    public ResponseEntity<?> taoOrderVatLieu (@RequestBody TaoOrderVatLieu taoOrderVatLieu) {
        return ResponseEntity.ok(vatLieuNVSCService.taoOrderVatLieu(taoOrderVatLieu));
    }

    @GetMapping("order/danh-sach-ok")
    public ResponseEntity<?> danhSachOrderVatLieuThanhCong(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(vatLieuNVSCService.danhSachOrderVatLieuOk_NVSC(page,pageSize));
    }

    @GetMapping("order/danh-sach-pending")
    public ResponseEntity<?> danhSachOrderVatLieuPending(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(vatLieuNVSCService.danhSachOrderVatLieuPending_NVSC(page,pageSize));
    }

    @GetMapping("tao/danh-sach")
    public ResponseEntity<?> danhSachVatLieuTheoModelVaLinhKien(@RequestParam String tenModel, @RequestParam String tenLinhKien) {
        return ResponseEntity.ok(vatLieuNVSCService.danhSachVatLieuTheoModelVaLinhKien(tenModel,tenLinhKien));
    }

    @GetMapping("order/{id}")
    public ResponseEntity<?> chiTietOrderTheoId (@PathVariable Integer id) {
        return ResponseEntity.ok(vatLieuNVSCService.chiTietOrderTheoId(id));
    }
}
