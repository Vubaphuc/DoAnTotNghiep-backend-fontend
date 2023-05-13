package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.entity.Oder;
import org.springframework.data.domain.Page;

public interface IOrderService {
    void save (Oder oder);
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuThanhCong(int page, int pageSize, String maNhanVien);
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuPending(int page, int pageSize, String maNhanVien);
}
