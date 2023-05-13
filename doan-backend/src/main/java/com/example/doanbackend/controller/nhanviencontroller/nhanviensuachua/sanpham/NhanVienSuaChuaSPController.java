package com.example.doanbackend.controller.nhanviencontroller.nhanviensuachua.sanpham;

import com.example.doanbackend.request.CapNhatThongTinChiTietSuaChuaSanPham;
import com.example.doanbackend.service.nhanviensuachua.NhanVienSuaChuaSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sua-chua")
public class NhanVienSuaChuaSPController {
    @Autowired
    private NhanVienSuaChuaSPService nhanVienSuaChuaSPService;

    @GetMapping("ds-sp")
    public ResponseEntity<?> layDanhSachSanPhamPhanPhatChoUser(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(nhanVienSuaChuaSPService.layDanhSachSanPhamPhanPhatChoUser(page,pageSize));
    }

    @GetMapping("san-pham/{id}")
    public ResponseEntity<?> layChiTietSanPhamTheoId(@PathVariable Integer id) {
        return ResponseEntity.ok(nhanVienSuaChuaSPService.layChiTietSanPhamTheoId(id));
    }

    @PutMapping("cap-nhat/{id}")
    public ResponseEntity<?> capNhatThongTinChiTietSuaChuaSanPham(@RequestBody CapNhatThongTinChiTietSuaChuaSanPham capNhatThongTinChiTietSuaChuaSanPham, @PathVariable Integer id) {
        return ResponseEntity.ok(nhanVienSuaChuaSPService.capNhatThongTinChiTietSuaChuaSanPham(capNhatThongTinChiTietSuaChuaSanPham, id));
    }
}
