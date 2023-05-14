package com.example.doanbackend.service.nhanvienbaohanh;

import com.example.doanbackend.dto.NhanVienDto;
import com.example.doanbackend.dto.page.PageNhanVienDto;
import com.example.doanbackend.service.jpaservice.EntityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class NhanVienBaoHanhService {
    @Autowired
    private EntityUserService entityUserService;
    public PageNhanVienDto danhSachNhanVienLeTanCoPhanTrang(int page, int pageSize) {
        Page<NhanVienDto> nhanVienDtoPage = entityUserService.danhSachNhanVienLeTanCoPhanTrang(page, pageSize);
        return new PageNhanVienDto(
                nhanVienDtoPage.getNumber() + 1,
                nhanVienDtoPage.getSize(),
                nhanVienDtoPage.getTotalPages(),
                (int) Math.ceil(nhanVienDtoPage.getTotalElements()),
                nhanVienDtoPage.getContent()
        );
    }
}
