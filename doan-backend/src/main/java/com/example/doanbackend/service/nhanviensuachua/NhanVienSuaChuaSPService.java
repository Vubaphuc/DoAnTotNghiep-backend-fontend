package com.example.doanbackend.service.nhanviensuachua;

import com.example.doanbackend.dto.DanhSachSanPhamNVSCDto;
import com.example.doanbackend.dto.LinhKienDto;
import com.example.doanbackend.dto.page.PageDanhSachSanPhamNVSC;
import com.example.doanbackend.dto.page.PageLinhKienNVK;
import com.example.doanbackend.entity.LinhKien;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.entity.ThongTinSuaChua;
import com.example.doanbackend.entity.User;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.request.CapNhatThongTinChiTietSuaChuaSanPham;
import com.example.doanbackend.response.StatusResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityLinhKienService;
import com.example.doanbackend.service.jpaservice.EntitySanPhamService;
import com.example.doanbackend.service.jpaservice.EntityThongTinSuaChuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class NhanVienSuaChuaSPService {
    @Autowired
    private EntitySanPhamService entitySanPhamService;
    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;
    @Autowired
    private EntityThongTinSuaChuaService entityThongTinSuaChuaService;
    @Autowired
    private EntityLinhKienService entityLinhKienService;

    public PageDanhSachSanPhamNVSC layDanhSachSanPhamPhanPhatChoUser(int page, int pageSize) {
       Page<DanhSachSanPhamNVSCDto> sanPhams = entitySanPhamService.layDanhSachSanPhamPhanPhatChoUser(page, pageSize,iCurrentUserLmpl.getUser().getId());
       return new PageDanhSachSanPhamNVSC(
               sanPhams.getNumber() + 1,
               sanPhams.getSize(),
               sanPhams.getTotalPages(),
               (int) Math.ceil(sanPhams.getTotalElements()),
               sanPhams.getContent()
       );
    }

    public DanhSachSanPhamNVSCDto layChiTietSanPhamTheoId(Integer id) {
        return entitySanPhamService.layChiTietSanPhamTheoId_NVSC(id,iCurrentUserLmpl.getUser().getId());
    }

    public StatusResponse capNhatThongTinChiTietSuaChuaSanPham(CapNhatThongTinChiTietSuaChuaSanPham capNhatThongTinChiTietSuaChuaSanPham, Integer id) {

        SanPham sanPham = entitySanPhamService.findById(id);
        if (sanPham.isTrangThai()) {
            throw new BadRequestException("Sản Phẩm Đã Đăng Ký Trước Đó");
        }
        LinhKien linhKien = entityLinhKienService.findById(capNhatThongTinChiTietSuaChuaSanPham.getViTriSua());

        ThongTinSuaChua thongTinSuaChua = entityThongTinSuaChuaService.findById(sanPham.getThongTinSuaChua().getId());

        thongTinSuaChua.setNguyenNhanLoi(capNhatThongTinChiTietSuaChuaSanPham.getNguyenNhanLoi());
        thongTinSuaChua.setChuThich(capNhatThongTinChiTietSuaChuaSanPham.getChuThich());
        thongTinSuaChua.setLinhKien(linhKien);


        entityThongTinSuaChuaService.save(thongTinSuaChua);

        sanPham.setTrangThai(capNhatThongTinChiTietSuaChuaSanPham.isTrangThai());
        sanPham.setThongTinSuaChua(thongTinSuaChua);


        entitySanPhamService.save(sanPham);

        return new StatusResponse(200, "Đăng Ký Thành Công");
    }

    public PageLinhKienNVK danhSachLinhKienDienThoai(int page, int pageSize) {
        Page<LinhKienDto> linhKienDtos = entityLinhKienService.danhSachLinhKien(page,pageSize);
        return new PageLinhKienNVK(
                linhKienDtos.getNumber() + 1,
                linhKienDtos.getSize(),
                linhKienDtos.getTotalPages(),
                (int) Math.ceil(linhKienDtos.getTotalElements()),
                linhKienDtos.getContent()
        );
    }
}
