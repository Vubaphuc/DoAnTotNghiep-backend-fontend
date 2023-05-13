package com.example.doanbackend.controller.nhanviencontroller.nhanvienkho;

import com.example.doanbackend.request.TaoMoiVender;
import com.example.doanbackend.service.nhanvienkho.VenderNVKService;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nhan-vien-kho/vender")
public class VenderNVKController {
    @Autowired
    private VenderNVKService venderNVKService;

    // lấy danh sách tất cả vender ra
    @GetMapping("danh-sach")
    public ResponseEntity<?> danhSachTatCaVender (@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(venderNVKService.danhSachTatCaVender(page,pageSize));
    }

    // Tạo mới 1 vender
    @PostMapping("tao-moi")
    public ResponseEntity<?> themVenderMoi (@RequestBody TaoMoiVender taoMoiVender) {
        return ResponseEntity.ok(venderNVKService.themVenderMoi(taoMoiVender));
    }

    // lấy 1 vender theo id
    @GetMapping("search/{id}")
    public ResponseEntity<?> layVenderRaTheoId (@PathVariable Integer id) {
        return ResponseEntity.ok(venderNVKService.layVenderRaTheoId(id));
    }

    // lấy 1 vender theo tên
    @GetMapping("tim-kiem/{name}")
    public ResponseEntity<?> layVenderRaTheoTen (@PathVariable String name) {
        return ResponseEntity.ok(venderNVKService.layVenderRaTheoTen(name));
    }

    // sửa tên vender
    @PutMapping("sua-ten/{id}")
    public ResponseEntity<?> suaTenVender (@RequestBody TaoMoiVender taoMoiVender ,@PathVariable Integer id) {
        return ResponseEntity.ok(venderNVKService.suaTenVender(taoMoiVender,id));
    }

    @GetMapping("tong")
    public ResponseEntity<?> danhSachVenderCoTongSoVatLieuDangCo(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(venderNVKService.danhSachVenderCoTongSoVatLieuDangCo(page,pageSize));
    }

    @GetMapping("chi-tiet")
    public ResponseEntity<?> danhSachChiTietVendorTheoId(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize,@RequestParam int vendorId) {
        return ResponseEntity.ok(venderNVKService.danhSachVatLieuTheoVendor(page,pageSize,vendorId));
    }
}
