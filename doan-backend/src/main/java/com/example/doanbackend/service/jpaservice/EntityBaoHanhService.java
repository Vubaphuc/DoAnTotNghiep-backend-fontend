package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.entity.BaoHanh;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.BaoHanhRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IBaoHanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityBaoHanhService implements IBaoHanhService {

    @Autowired
    private BaoHanhRepository baoHanhRepository;
    @Override
    public BaoHanh save(BaoHanh baoHanh) {
        baoHanhRepository.save(baoHanh);
        return baoHanh;
    }

    @Override
    public BaoHanh updateById(Integer id) {
        BaoHanh baoHanh = baoHanhRepository.findBaoHanhById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy Bảo hành với id = " + id);
        });
        baoHanhRepository.save(baoHanh);
        return baoHanh;
    }

    @Override
    public BaoHanh deleteById(Integer id) {
        BaoHanh baoHanh = baoHanhRepository.findBaoHanhById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy Bảo hành với id = " + id);
        });
        baoHanhRepository.deleteById(baoHanh.getId());
        return baoHanh;
    }
}
