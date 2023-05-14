package com.example.doanbackend.service.nhanviensuachua;

import com.example.doanbackend.dto.DanhSachSanPhamNVSCDto;
import com.example.doanbackend.dto.page.PageDanhSachSanPhamNVSC;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.entity.ThongTinSuaChua;
import com.example.doanbackend.entity.User;
import com.example.doanbackend.request.CapNhatThongTinChiTietSuaChuaSanPham;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntitySanPhamService;
import com.example.doanbackend.service.jpaservice.EntityThongTinSuaChuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class NhanVienSuaChuaSPService {
    @Autowired
    private EntitySanPhamService entitySanPhamService;
    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;
    @Autowired
    private EntityThongTinSuaChuaService entityThongTinSuaChuaService;

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

    public String capNhatThongTinChiTietSuaChuaSanPham(CapNhatThongTinChiTietSuaChuaSanPham capNhatThongTinChiTietSuaChuaSanPham, Integer id) {

        SanPham sanPham = entitySanPhamService.findById(id);
        if (sanPham.getTrangThai().equals("OK")) {
            return "Sản phẩm đã cập nhât thông tin rồi";
        }

        ThongTinSuaChua thongTinSuaChua = entityThongTinSuaChuaService.findById(sanPham.getThongTinSuaChua().getId());

        thongTinSuaChua.setViTriSua(capNhatThongTinChiTietSuaChuaSanPham.getViTriSua());
        thongTinSuaChua.setNguyenNhanLoi(capNhatThongTinChiTietSuaChuaSanPham.getNguyenNhanLoi());
        thongTinSuaChua.setChuThich(capNhatThongTinChiTietSuaChuaSanPham.getChuThich());
        // thiếu thêm loại linh kiện

        entityThongTinSuaChuaService.save(thongTinSuaChua);

        sanPham.setTrangThai(capNhatThongTinChiTietSuaChuaSanPham.getTrangThai());
        sanPham.setThongTinSuaChua(thongTinSuaChua);


        entitySanPhamService.save(sanPham);

        return "Cập nhật thành công";
    }
}
