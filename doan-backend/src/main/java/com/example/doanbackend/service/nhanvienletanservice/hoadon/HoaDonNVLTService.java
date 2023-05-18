package com.example.doanbackend.service.nhanvienletanservice.hoadon;

import com.example.doanbackend.config.GenerateCode;
import com.example.doanbackend.dto.HoaDonSanPhamDto;
import com.example.doanbackend.entity.*;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.request.TaoMoiHoaDon;
import com.example.doanbackend.response.StatusResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityBaoHanhService;
import com.example.doanbackend.service.jpaservice.EntityHoaDonService;
import com.example.doanbackend.service.jpaservice.EntitySanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonNVLTService {
    @Autowired
    private EntitySanPhamService entitySanPhamService;

    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;
    @Autowired
    private GenerateCode generateCode;
    @Autowired
    private EntityBaoHanhService entityBaoHanhService;

    @Autowired
    private EntityHoaDonService entityHoaDonService;


    public HoaDonSanPhamDto layChiTietSanPhamOKTheoID(Integer id) {
        return entitySanPhamService.layChiTietSanPhamOKTheoID(id);
    }



}
