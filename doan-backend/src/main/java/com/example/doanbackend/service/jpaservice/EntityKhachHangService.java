package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.KhachHangRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityKhachHangService implements IKhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;


    @Override
    public void save(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang deleteById(Integer id) {
        // chưa có logic
        return null;
    }
    @Override
    public KhachHang findById(Integer id) {
        return khachHangRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không Tìm Thấy Khách Hàng có id là " + id);
        });
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public KhachHang updateById(Integer id) {

        // chưa có logic


        return null;
    }

    @Override
    public Optional<KhachHang> layRaKhachHangTheoEmail(String email) {

        return khachHangRepository.findByEmail(email);
    }

    @Override
    public Page<DanhSachKhachHangCoSanPhamNVLT> danhSachKhachHangCoSanPhamOk(int page, int pageSize) {
        return null;
    }

    @Override
    public Page<DanhSachKhachHangCoSanPhamNVLT> danhSachKhachHangCoSanPhamPeding(int page, int pageSize) {
        return null;
    }
}
