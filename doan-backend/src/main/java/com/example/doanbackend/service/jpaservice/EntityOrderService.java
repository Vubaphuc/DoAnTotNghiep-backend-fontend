package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.HistoryOrderMaterial;
import com.example.doanbackend.dto.OrderDto;
import com.example.doanbackend.entity.OrderMaterial;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.OrderMaterialRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EntityOrderService implements IOrderService {
    @Autowired
    private OrderMaterialRepository orderMaterialRepository;

    @Override
    public void save(OrderMaterial orderMaterial) {
        orderMaterialRepository.save(orderMaterial);
    }


    @Override
    public OrderMaterial findById(Integer id) {
        return orderMaterialRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not Found With " + id);
        });
    }

    @Override
    public Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuOk_NVSC(int page, int pageSize, Integer id) {
        return orderMaterialRepository.danhSachOrderVatLieuOk_NVSC(PageRequest.of(page - 1, pageSize), id);
    }

    @Override
    public Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuPending_NVSC(int page, int pageSize, Integer id) {
        return orderMaterialRepository.danhSachOrderVatLieuPending_NVSC(PageRequest.of(page - 1, pageSize), id);
    }


    @Override
    public OrderDto chiTietOrderTheoId(Integer id) {
        return orderMaterialRepository.chiTietOrderTheoId(id).orElseThrow(() -> {
            throw new NotFoundException("Không Tìm Thấy Order nào có id là " + id);
        });
    }

    @Override
    public Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuOk_NVK(int page, int pageSize, Integer id) {
        return orderMaterialRepository.danhSachOrderVatLieuOk_NVK(PageRequest.of(page - 1, pageSize), id);
    }

    @Override
    public Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuPending_NVK(int page, int pageSize) {
        return orderMaterialRepository.danhSachOrderVatLieuPending_NVK(PageRequest.of(page - 1, pageSize));
    }


    @Override
    public Page<HistoryOrderMaterial> timKiemOrderVatLieuTheoTerm(int page, int pageSize, String term) {
        return orderMaterialRepository.timKiemOrderVatLieuTheoTerm(PageRequest.of(page - 1, pageSize), term);
    }
}
