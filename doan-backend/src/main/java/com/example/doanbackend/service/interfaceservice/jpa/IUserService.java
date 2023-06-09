package com.example.doanbackend.service.interfaceservice.jpa;


import com.example.doanbackend.dto.NhanVienDto;
import com.example.doanbackend.dto.userdto.NhanVienSuaChuaDto;
import com.example.doanbackend.dto.userdto.UserDto;
import com.example.doanbackend.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {
    User save(User user);
    User updateById(Integer id);
    User deleteById(Integer id);
    List<NhanVienSuaChuaDto> layDanhSachNhanVienSuaChua();
    User timKiemUserBangEmail(String email);
    User findByMaNhanVien(String maNhanVien);
    Page<NhanVienDto> danhSachNhanVienSuaChuaCoPhanTrang(int page, int pageSize);
}
