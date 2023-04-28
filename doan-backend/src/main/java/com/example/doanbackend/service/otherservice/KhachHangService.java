package com.example.doanbackend.service.otherservice;

import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.KhachHangRepository;
import com.example.doanbackend.service.interfaceservice.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangService implements IKhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;


    @Override
    public KhachHang save(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
        return khachHang;
    }

    @Override
    public KhachHang deleteById(Integer id) {
        KhachHang khachHang = khachHangRepository.findKhachHangById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy khách hàng có id = " + id);
        });

        khachHangRepository.save(khachHang);
        return khachHang;
    }

    @Override
    public KhachHang updateById(Integer id) {
        KhachHang khachHang = khachHangRepository.findKhachHangById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy khách hàng có id = " + id);
        });

        khachHangRepository.deleteById(khachHang.getId());
        return khachHang;
    }
}
