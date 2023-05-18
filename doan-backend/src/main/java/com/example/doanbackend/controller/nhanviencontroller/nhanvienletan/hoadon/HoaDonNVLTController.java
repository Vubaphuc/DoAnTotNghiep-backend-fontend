package com.example.doanbackend.controller.nhanviencontroller.nhanvienletan.hoadon;

import com.example.doanbackend.request.TaoMoiHoaDon;
import com.example.doanbackend.service.nhanvienletanservice.hoadon.HoaDonNVLTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("le-tan/hoa-don")
public class HoaDonNVLTController {
    @Autowired
    private HoaDonNVLTService hoaDonNVLTService;


    @GetMapping("san-pham/{id}")
    public ResponseEntity<?> layChiTietSanPhamOKTheoID(@PathVariable Integer id) {
        return ResponseEntity.ok(hoaDonNVLTService.layChiTietSanPhamOKTheoID(id));
    }

}
