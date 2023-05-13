package com.example.doanbackend.service.nhanviensuachua;

import com.example.doanbackend.config.GenerateCode;
import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.DanhSachVatLieuDto;
import com.example.doanbackend.dto.VatLieuSuaChuaDto;
import com.example.doanbackend.dto.page.PageDanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.page.PageDanhSachVatLieuDto;
import com.example.doanbackend.entity.LinhKien;
import com.example.doanbackend.entity.Oder;
import com.example.doanbackend.entity.VatLieu;
import com.example.doanbackend.request.TaoOrderVatLieu;
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
    public String taoOrderVatLieu(TaoOrderVatLieu taoOrderVatLieu) {

        VatLieu vatLieu = entityVatLieuService.findByCode(taoOrderVatLieu.getCode());

        LinhKien linhKien = entityLinhKienService.findByName(taoOrderVatLieu.getLoaiLinhKien());



        Oder oder = Oder.builder()
                .maOder(generateCode.generateCode())
                .soLuong(taoOrderVatLieu.getSoLuong())
                .vatLieus(List.of(vatLieu))
                .linhKien(linhKien)
                .nhanVienOder(iCurrentUserLmpl.getUser())
                .build();

        entityOrderService.save(oder);


        return "Tạo Thành Công";

    }

    public PageDanhSachStatusOrderNVSC danhSachOrderVatLieuThanhCong(int page, int pageSize) {

        Page<DanhSachStatusOrderNVSC> orderNVSCPage =entityOrderService.danhSachOrderVatLieuThanhCong(page,pageSize, iCurrentUserLmpl.getUser().getMaNhanVien());

        return new PageDanhSachStatusOrderNVSC(
                orderNVSCPage.getNumber() + 1,
                orderNVSCPage.getSize(),
                orderNVSCPage.getTotalPages(),
                (int) Math.ceil(orderNVSCPage.getTotalElements()),
                orderNVSCPage.getContent()
        );
    }

    public PageDanhSachStatusOrderNVSC danhSachOrderVatLieuPending(int page, int pageSize) {

        Page<DanhSachStatusOrderNVSC> orderNVSCPage = entityOrderService.danhSachOrderVatLieuPending(page,pageSize,iCurrentUserLmpl.getUser().getMaNhanVien());

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
}
