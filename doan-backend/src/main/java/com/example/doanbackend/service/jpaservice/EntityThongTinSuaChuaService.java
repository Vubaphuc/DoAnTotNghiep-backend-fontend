package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.entity.ThongTinSuaChua;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.ThongTinSuaChuaRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IThongTinSuaChua;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityThongTinSuaChuaService implements IThongTinSuaChua {
    @Autowired
    private ThongTinSuaChuaRepository thongTinSuaChuaRepository;
    @Override
    public void save(ThongTinSuaChua thongTinSuaChua) {
        thongTinSuaChuaRepository.save(thongTinSuaChua);
    }

    @Override
    public ThongTinSuaChua findById(Integer id) {
        return thongTinSuaChuaRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy thông tin nào");
        });
    }
}
