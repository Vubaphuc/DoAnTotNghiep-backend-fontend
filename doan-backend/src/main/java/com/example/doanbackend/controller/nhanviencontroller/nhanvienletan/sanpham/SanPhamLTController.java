package com.example.doanbackend.controller.nhanviencontroller.nhanvienletan.sanpham;

import com.example.doanbackend.request.CapNhatThongTinNhanVienSuaChua;
import com.example.doanbackend.request.TaoMoiHoaDon;
import com.example.doanbackend.request.TaoSanPhamMoi;
import com.example.doanbackend.service.nhanvienletanservice.sanpham.SanPhamLTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/le-tan/san-pham")
public class SanPhamLTController {

    @Autowired
    private SanPhamLTService sanPhamLTService;

    // lấy danh sách sản phẩm mới đăng ký
    @GetMapping("moi-dang-ky")
    public ResponseEntity<?> layDanhSachSanPhamMoiDangKy(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(sanPhamLTService.layDanhSachSanPhamMoiDangKy(page,pageSize,term));
    }
    // lấy ra ra chi tiết sản phẩm theo id
    @GetMapping("chi-tiet/{id}")
    public ResponseEntity<?> layChiTietSanPhamTheoId(@PathVariable Integer id) {
        return ResponseEntity.ok(sanPhamLTService.layChiTietSanPhamTheoId(id));
    }

    // cập nhật thông tin nhân viên sửa chữa
    @PutMapping("cap-nhat/{id}")
    public ResponseEntity<?> capNhatThongTinNhanVienSuaChua(@RequestBody CapNhatThongTinNhanVienSuaChua capNhatThongTinNhanVienSuaChua,@PathVariable Integer id) {
        sanPhamLTService.capNhatThongTinNhanVienSuaChua(capNhatThongTinNhanVienSuaChua, id);
        return ResponseEntity.noContent().build();
    }

    // lấy ra danh sách sản phẩm sửa ok
    @GetMapping("sua-xong")
    public ResponseEntity<?> danhSachSanPhamDaSuaChuaOK(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(sanPhamLTService.danhSachSanPhamDaSuaChuaOK(page, pageSize,term));
    }

    @GetMapping("tat-ca")
    public ResponseEntity<?> timKiemLichSuSanPhamTheoTerm(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "") String term) {
        return ResponseEntity.ok(sanPhamLTService.timKiemLichSuSanPhamTheoTerm(page,pageSize,term));
    }

    @PostMapping("tao-moi")
    public ResponseEntity<?> dangKySanPhamMoi (@RequestBody TaoSanPhamMoi taoSanPhamMoi) {
        return ResponseEntity.ok(sanPhamLTService.dangKySanPhamMoi(taoSanPhamMoi));
    }

    @PostMapping("san-pham")
    public ResponseEntity<?> taoHoaDonMoi(@RequestBody TaoMoiHoaDon taoMoiHoaDon) {
        return ResponseEntity.ok(sanPhamLTService.taoHoaDonMoi(taoMoiHoaDon));
    }



}
