package com.example.doanbackend.service.nhanvienkho;

import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.page.PageDanhSachStatusOrderNVSC;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class OderVatLieuNVKService {
    @Autowired
    private EntityOrderService entityOrderService;
    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;
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
}
