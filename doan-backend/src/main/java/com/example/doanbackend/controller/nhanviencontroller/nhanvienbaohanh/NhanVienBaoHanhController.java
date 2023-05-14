package com.example.doanbackend.controller.nhanviencontroller.nhanvienbaohanh;

import com.example.doanbackend.service.nhanvienbaohanh.NhanVienBaoHanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bao-hanh")
public class NhanVienBaoHanhController {
    @Autowired
    private NhanVienBaoHanhService nhanVienBaoHanhService;

    @GetMapping("danh-sach/le-tan")
    public ResponseEntity<?> danhSachNhanVienLeTanCoPhanTrang(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(nhanVienBaoHanhService.danhSachNhanVienLeTanCoPhanTrang(page,pageSize));
    }
}
