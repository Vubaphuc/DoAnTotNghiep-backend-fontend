package com.example.doanbackend.controller.nhanviencontroller.nhanvienkho;

import com.example.doanbackend.request.PheDuyetOrder;
import com.example.doanbackend.service.nhanvienkho.OderVatLieuNVKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nhan-vien-kho/oder")
public class OderVatLieuNVKController {
    @Autowired
    private OderVatLieuNVKService oderVatLieuNVKService;

    @GetMapping("danh-sach-pending")
    public ResponseEntity<?> danhSachOrderVatLieuPending(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(oderVatLieuNVKService.danhSachOrderVatLieuPending_NVK(page,pageSize));
    }

    @GetMapping("danh-sach-ok")
    public ResponseEntity<?> danhSachOrderVatLieuOk(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(oderVatLieuNVKService.danhSachOrderVatLieuOk_NVK(page,pageSize));
    }

    @GetMapping("chi-tiet/{id}")
    public ResponseEntity<?> chiTietOrderTheoId_NVK (@PathVariable Integer id) {
        return ResponseEntity.ok(oderVatLieuNVKService.chiTietOrderTheoId_NVK(id));
    }

    @PutMapping("phe-duyet/{id}")
    public ResponseEntity<?> pheDuyetOrderVatLieu (@RequestBody PheDuyetOrder pheDuyetOrder, @PathVariable Integer id) {
        return ResponseEntity.ok(oderVatLieuNVKService.pheDuyetOrderVatLieu(pheDuyetOrder,id));
    }

    @GetMapping("danh-sach")
    public ResponseEntity<?> timKiemOrderVatLieuTheoTerm(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,@RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(oderVatLieuNVKService.timKiemOrderVatLieuTheoTerm(page,pageSize,term));
    }
}
