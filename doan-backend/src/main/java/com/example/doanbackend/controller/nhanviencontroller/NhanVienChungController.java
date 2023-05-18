package com.example.doanbackend.controller.nhanviencontroller;


import com.example.doanbackend.entity.Image;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.request.CapNhatThongTinCaNhan;
import com.example.doanbackend.request.DoiMatKhau;
import com.example.doanbackend.request.QuenMatKhau;
import com.example.doanbackend.service.nhanvienservice.NhanVienChungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;


@RestController
@RequestMapping("nhan-vien")
public class NhanVienChungController {

    @Autowired
    private NhanVienChungService nhanVienChungService;



    @PostMapping("quen-mat-khau")
    public ResponseEntity<?> quenMatKhau(@RequestBody QuenMatKhau quenMatKhau) {
        return ResponseEntity.ok(nhanVienChungService.quenMatKhau(quenMatKhau));
    }


    @PutMapping("doi-mat-khau")
    public ResponseEntity<?> doiMatKhau(@RequestBody DoiMatKhau doiMatKhau) {
        return ResponseEntity.ok(nhanVienChungService.doiMatKhau(doiMatKhau));
    }

    @PutMapping("cap-nhat")
    public ResponseEntity<?> capNhatThongTinCaNhan(@RequestBody CapNhatThongTinCaNhan capNhatThongTinCaNhan) {
        return ResponseEntity.ok(nhanVienChungService.capNhatThongTinCaNhan(capNhatThongTinCaNhan));
    }

    @PostMapping("upload-avatar")
    public ResponseEntity<?> capNhatAnhDaiDien(@ModelAttribute("avatar") MultipartFile avatar) {
        return ResponseEntity.ok(nhanVienChungService.capNhatAnhDaiDien(avatar));
    }

    @GetMapping("avatar/{id}")
    public ResponseEntity<?> layAnhdaiDienTheoId(@PathVariable Integer id) {
        Image image = nhanVienChungService.layAnhdaiDienTheoId(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .body(image.getData());

    }

}
