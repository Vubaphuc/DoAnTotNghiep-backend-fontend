package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT;
import com.example.doanbackend.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IKhachHangService {
    void save (KhachHang khachHang);
    KhachHang deleteById(Integer id);
    KhachHang findById(Integer id);
    List<KhachHang> findAll();

    KhachHang updateById(Integer id);

    Optional<KhachHang> layRaKhachHangTheoEmail(String email);

    Page<DanhSachKhachHangCoSanPhamNVLT> danhSachKhachHangCoSanPhamOk(int page, int pageSize);
    Page<DanhSachKhachHangCoSanPhamNVLT> danhSachKhachHangCoSanPhamPeding(int page, int pageSize);
}
