package com.example.doanbackend.controller.nhanviencontroller.nhanvienletan;

import com.example.doanbackend.service.nhanvienletanservice.NhanVienLeTanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("le-tan")
public class NhanVienLeTanController {

    @Autowired
    private NhanVienLeTanService nhanVienLeTanService;

    @GetMapping("sua-chua")
    public ResponseEntity<?> layDanhSachNhanVienSuaChua() {
        return ResponseEntity.ok(nhanVienLeTanService.layDanhSachNhanVienSuaChua());
    }

}
