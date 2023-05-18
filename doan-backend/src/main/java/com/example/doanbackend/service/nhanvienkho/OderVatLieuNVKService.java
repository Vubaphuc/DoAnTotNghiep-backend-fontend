package com.example.doanbackend.service.nhanvienkho;

import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.HistoryOrderMaterial;
import com.example.doanbackend.dto.OrderDto;
import com.example.doanbackend.dto.page.PageDanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.page.PageHistoryNhanVienLeTanDto;
import com.example.doanbackend.dto.page.PageHistoryOrderMaterial;
import com.example.doanbackend.entity.OrderMaterial;
import com.example.doanbackend.entity.VatLieu;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.request.PheDuyetOrder;
import com.example.doanbackend.response.StatusResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityOrderService;
import com.example.doanbackend.service.jpaservice.EntityVatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OderVatLieuNVKService {
    @Autowired
    private EntityOrderService entityOrderService;
    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;
    @Autowired
    private EntityVatLieuService entityVatLieuService;

    public PageDanhSachStatusOrderNVSC danhSachOrderVatLieuPending_NVK(int page, int pageSize) {

        Page<DanhSachStatusOrderNVSC> orderNVSCPage = entityOrderService.danhSachOrderVatLieuPending_NVK(page,pageSize);

        return new PageDanhSachStatusOrderNVSC(
                orderNVSCPage.getNumber() + 1,
                orderNVSCPage.getSize(),
                orderNVSCPage.getTotalPages(),
                (int) Math.ceil(orderNVSCPage.getTotalElements()),
                orderNVSCPage.getContent()
        );
    }

    public PageDanhSachStatusOrderNVSC danhSachOrderVatLieuOk_NVK(int page, int pageSize) {

        Page<DanhSachStatusOrderNVSC> orderNVSCPage = entityOrderService.danhSachOrderVatLieuOk_NVK(page,pageSize,iCurrentUserLmpl.getUser().getId());
        return new PageDanhSachStatusOrderNVSC(
                orderNVSCPage.getNumber() + 1,
                orderNVSCPage.getSize(),
                orderNVSCPage.getTotalPages(),
                (int) Math.ceil(orderNVSCPage.getTotalElements()),
                orderNVSCPage.getContent()
        );
    }

    public OrderDto chiTietOrderTheoId_NVK(Integer id) {
        return entityOrderService.chiTietOrderTheoId(id);
    }

    public StatusResponse pheDuyetOrderVatLieu(PheDuyetOrder pheDuyetOrder, Integer id) {

        OrderMaterial orderMaterial = entityOrderService.findById(id);

        if (orderMaterial.getApprover() != null) {
            throw new BadRequestException("Order đã được phê Duyệt");
        }


        orderMaterial.setApprover(iCurrentUserLmpl.getUser());
        orderMaterial.setStatus(pheDuyetOrder.isTrangThai());

        entityOrderService.save(orderMaterial);

        VatLieu vatLieu = entityVatLieuService.findByCode(pheDuyetOrder.getMaVatLieu());
        vatLieu.setSoLuong(vatLieu.getSoLuong() - pheDuyetOrder.getSoLuong());

        entityVatLieuService.save(vatLieu);

        return new StatusResponse(200, "Phê Duyệt Thành công");
    }

    public PageHistoryOrderMaterial timKiemOrderVatLieuTheoTerm(int page, int pageSize, String term) {

        if (term == null || term.trim().isEmpty()) {
            return new PageHistoryOrderMaterial(
                    0,0,0,0,new ArrayList<>()
            );
        }

        Page<HistoryOrderMaterial> historyOrderMaterials = entityOrderService.timKiemOrderVatLieuTheoTerm(page,pageSize,term);

        return new PageHistoryOrderMaterial(
                historyOrderMaterials.getNumber() + 1,
                historyOrderMaterials.getSize(),
                historyOrderMaterials.getTotalPages(),
                (int) Math.ceil(historyOrderMaterials.getTotalElements()),
                historyOrderMaterials.getContent()
        );
    }
}
