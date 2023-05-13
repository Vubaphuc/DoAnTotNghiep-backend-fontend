package com.example.doanbackend.service.nhanvienletanservice;

import com.example.doanbackend.dto.userdto.NhanVienSuaChuaDto;
import com.example.doanbackend.dto.userdto.UserDto;
import com.example.doanbackend.service.jpaservice.EntityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienLeTanService {
    @Autowired
    private EntityUserService entityUserService;

    // lấy danh sách nhân viên sửa chữa
    public List<NhanVienSuaChuaDto> layDanhSachNhanVienSuaChua() {
        return entityUserService.layDanhSachNhanVienSuaChua();
    }
}
