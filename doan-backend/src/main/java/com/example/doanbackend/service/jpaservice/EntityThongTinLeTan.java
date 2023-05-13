package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.entity.ThongTinLeTan;
import com.example.doanbackend.repository.ThongTinLeTanRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IThongTinLeTan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityThongTinLeTan implements IThongTinLeTan {

    @Autowired
    private ThongTinLeTanRepository thongTinLeTanRepository;
    @Override
    public void save(ThongTinLeTan thongTinLeTan) {
        thongTinLeTanRepository.save(thongTinLeTan);
    }
}
