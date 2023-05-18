package com.example.doanbackend.service.nhanviensuachua;

import com.example.doanbackend.config.GenerateCode;
import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.DanhSachVatLieuDto;
import com.example.doanbackend.dto.OrderDto;
import com.example.doanbackend.dto.VatLieuSuaChuaDto;
import com.example.doanbackend.dto.page.PageDanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.page.PageDanhSachVatLieuDto;
import com.example.doanbackend.entity.LinhKien;
import com.example.doanbackend.entity.OrderMaterial;
import com.example.doanbackend.entity.VatLieu;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.request.TaoOrderVatLieu;
import com.example.doanbackend.response.StatusResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityLinhKienService;
import com.example.doanbackend.service.jpaservice.EntityOrderService;
import com.example.doanbackend.service.jpaservice.EntityVatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VatLieuNVSCService {
    @Autowired
    private EntityVatLieuService entityVatLieuService;
    @Autowired
    private EntityLinhKienService entityLinhKienService;
    @Autowired
    private GenerateCode generateCode;
    @Autowired
    ICurrentUserLmpl iCurrentUserLmpl;
    @Autowired
    private EntityOrderService entityOrderService;

    public PageDanhSachVatLieuDto danhSachVatLieuConHang(int page, int pageSize) {

        Page<DanhSachVatLieuDto> vatLieuDtos = entityVatLieuService.danhSachVatLieuAll(page,pageSize);

        return new PageDanhSachVatLieuDto(
                vatLieuDtos.getNumber() + 1,
                vatLieuDtos.getSize(),
                vatLieuDtos.getTotalPages(),
                (int) Math.ceil(vatLieuDtos.getTotalElements()),
                vatLieuDtos.getContent()
        );
    }

    public VatLieuSuaChuaDto layVatLieuTheoCode(String code) {
        return entityVatLieuService.layVatLieuTheoCode(code);
    }

    // tạo order vật liệu
    public StatusResponse taoOrderVatLieu(TaoOrderVatLieu taoOrderVatLieu) {

        VatLieu vatLieu = entityVatLieuService.findByCode(taoOrderVatLieu.getCode());
        if (vatLieu.getSoLuong() == 0) {
            throw new BadRequestException("Vật Liệu Không còn hàng trong kho");
        }

        LinhKien linhKien = entityLinhKienService.findByName(taoOrderVatLieu.getLoaiLinhKien());


//
        OrderMaterial orderMaterial = OrderMaterial.builder()
                .orderCode(generateCode.generateCode())
                .quantity(taoOrderVatLieu.getSoLuong())
                .material(vatLieu)
                .accessory(linhKien)
                .petitioner(iCurrentUserLmpl.getUser())
                .build();

        entityOrderService.save(orderMaterial);


        return new StatusResponse(200,"Order Thành Công");

    }

    public PageDanhSachStatusOrderNVSC danhSachOrderVatLieuOk_NVSC(int page, int pageSize) {

        Page<DanhSachStatusOrderNVSC> orderNVSCPage =entityOrderService.danhSachOrderVatLieuOk_NVSC(page,pageSize, iCurrentUserLmpl.getUser().getId());

        return new PageDanhSachStatusOrderNVSC(
                orderNVSCPage.getNumber() + 1,
                orderNVSCPage.getSize(),
                orderNVSCPage.getTotalPages(),
                (int) Math.ceil(orderNVSCPage.getTotalElements()),
                orderNVSCPage.getContent()
        );
    }

    public PageDanhSachStatusOrderNVSC danhSachOrderVatLieuPending_NVSC(int page, int pageSize) {

        Page<DanhSachStatusOrderNVSC> orderNVSCPage = entityOrderService.danhSachOrderVatLieuPending_NVSC(page,pageSize,iCurrentUserLmpl.getUser().getId());

        return new PageDanhSachStatusOrderNVSC(
                orderNVSCPage.getNumber() + 1,
                orderNVSCPage.getSize(),
                orderNVSCPage.getTotalPages(),
                (int) Math.ceil(orderNVSCPage.getTotalElements()),
                orderNVSCPage.getContent()
        );
    }

    public List<VatLieuSuaChuaDto> danhSachVatLieuTheoModelVaLinhKien(String tenModel, String tenLinhKien) {
        return entityVatLieuService.danhSachVatLieuTheoModelVaLinhKien(tenModel,tenLinhKien);
    }

    public OrderDto chiTietOrderTheoId(Integer id) {
        return entityOrderService.chiTietOrderTheoId(id);
    }
}
