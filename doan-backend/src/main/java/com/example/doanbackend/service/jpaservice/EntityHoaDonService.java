package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.entity.HoaDon;
import com.example.doanbackend.repository.HoaDonRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityHoaDonService implements IHoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Override
    public void save(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
    }
}
