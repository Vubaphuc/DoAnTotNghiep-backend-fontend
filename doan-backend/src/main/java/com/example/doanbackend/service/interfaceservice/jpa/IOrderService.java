package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.HistoryOrderMaterial;
import com.example.doanbackend.dto.OrderDto;
import com.example.doanbackend.entity.OrderMaterial;
import org.springframework.data.domain.Page;

public interface IOrderService {
     void save (OrderMaterial orderMaterial);
    OrderMaterial findById(Integer id);
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuOk_NVSC(int page, int pageSize, Integer id);
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuPending_NVSC(int page, int pageSize, Integer id);
    OrderDto chiTietOrderTheoId(Integer id);

    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuOk_NVK(int page, int pageSize, Integer id);
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuPending_NVK(int page, int pageSize);
    Page<HistoryOrderMaterial> timKiemOrderVatLieuTheoTerm(int page, int pageSize, String term);
}
