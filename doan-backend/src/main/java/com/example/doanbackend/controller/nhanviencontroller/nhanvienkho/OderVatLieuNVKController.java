package com.example.doanbackend.controller.nhanviencontroller.nhanvienkho;

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
        return ResponseEntity.ok(oderVatLieuNVKService.danhSachOrderVatLieuPending(page,pageSize));
    }

    @PutMapping("phe-duyet")
    public ResponseEntity<?> pheDuyetOrderVatLieu () {
        return ResponseEntity.ok(null);
    }
}
