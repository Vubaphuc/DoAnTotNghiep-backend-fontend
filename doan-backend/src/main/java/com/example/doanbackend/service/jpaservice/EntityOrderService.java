package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.entity.Oder;
import com.example.doanbackend.repository.OderRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EntityOrderService implements IOrderService {
    @Autowired
    private OderRepository oderRepository;
    @Override
    public void save(Oder oder) {
        oderRepository.save(oder);
    }

    @Override
    public Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuThanhCong(int page, int pageSize, String maNhanVien) {
        return oderRepository.danhSachOrderVatLieuThanhCong(PageRequest.of(page - 1, pageSize),maNhanVien);
    }

    @Override
    public Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuPending(int page, int pageSize, String maNhanVien) {
        return oderRepository.danhSachOrderVatLieuPending(PageRequest.of(page - 1, pageSize),maNhanVien);
    }
}
