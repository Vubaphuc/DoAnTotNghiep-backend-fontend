package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.entity.ThongTinLeTan;
import com.example.doanbackend.entity.ThongTinSuaChua;

public interface IThongTinSuaChua {

    void save (ThongTinSuaChua thongTinSuaChua);

    ThongTinSuaChua findById(Integer id);
}
