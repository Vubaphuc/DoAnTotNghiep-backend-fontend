package com.example.doanbackend.controller.nhanviencontroller.nhanvienbaohanh;

import com.example.doanbackend.repository.SanPhamRepository;
import com.example.doanbackend.request.CapNhatThongTinNhanVienSuaChua;
import com.example.doanbackend.request.DangKyNhanVienSuaBaoHanh;
import com.example.doanbackend.request.ThongTinBaoHanhCoTinhPhi;
import com.example.doanbackend.request.ThongTinBaoHanhKhongTinhPhi;
import com.example.doanbackend.service.nhanvienbaohanh.NhanVienBaoHanhService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bao-hanh")
@Slf4j
public class NhanVienBaoHanhController {
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    private NhanVienBaoHanhService nhanVienBaoHanhService;

    @GetMapping("danh-sach/sua-chua")
    public ResponseEntity<?> danhSachNhanVienSuaChuaCoPhanTrang(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(nhanVienBaoHanhService.danhSachNhanVienSuaChuaCoPhanTrang(page,pageSize));
    }

    @GetMapping("search/history-product")
    public ResponseEntity<?> searchHistoryProductByTerm(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(nhanVienBaoHanhService.searchHistoryProductByTerm(page,pageSize,term));
    }

    @GetMapping("product/{id}")
    public ResponseEntity<?> findProductAndCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(nhanVienBaoHanhService.findProductAndCustomerById(id));
    }

    @GetMapping("san-pham/bao-hanh/{id}")
    public ResponseEntity<?> sanPhamBaoHanhTheoId(@PathVariable Integer id) {
        return ResponseEntity.ok(nhanVienBaoHanhService.sanPhamBaoHanhTheoId(id));
    }

    @PostMapping("dang-ky/tinh-phi")
    public ResponseEntity<?> registerNewProductWarrantyMoney(@RequestBody ThongTinBaoHanhCoTinhPhi request) {
        return ResponseEntity.ok(nhanVienBaoHanhService.registerNewProductWarrantyMoney(request));
    }

    @PostMapping("dang-ky/khong-tinh-phi")
    public ResponseEntity<?> registerNewProductWarrantyNoMoney(@RequestBody ThongTinBaoHanhKhongTinhPhi request) {
        return ResponseEntity.ok(nhanVienBaoHanhService.registerNewProductWarrantyNoMoney(request));
    }

    @GetMapping("danh-sach/pending")
    public ResponseEntity<?> danhSachSanPhamBaoHanhPending(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(nhanVienBaoHanhService.danhSachSanPhamBaoHanhPending(page,pageSize,term));
    }

    @GetMapping("danh-sach/ok")
    public ResponseEntity<?> danhSachSanPhamBaoHanhOk(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(nhanVienBaoHanhService.danhSachSanPhamBaoHanhOk(page,pageSize,term));
    }

    @GetMapping("danh-sach/tat-ca")
    public ResponseEntity<?> danhSachSanPhamBaoHanhTatCa(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(nhanVienBaoHanhService.danhSachSanPhamBaoHanhTatCa(page,pageSize,term));
    }

    @PutMapping("san-pham/nhan-vien-sua-chua/{id}")
    public ResponseEntity<?> capNhatThongTinNhanVienSuaChua(@RequestBody DangKyNhanVienSuaBaoHanh dangKyNhanVienSuaBaoHanh, @PathVariable Integer id) {
        return ResponseEntity.ok(nhanVienBaoHanhService.capNhatThongTinNhanVienSuaChua(dangKyNhanVienSuaBaoHanh, id));
    }
}
