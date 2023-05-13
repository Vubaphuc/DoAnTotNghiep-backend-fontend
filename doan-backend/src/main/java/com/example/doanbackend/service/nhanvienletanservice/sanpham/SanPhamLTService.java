package com.example.doanbackend.service.nhanvienletanservice.sanpham;

import com.example.doanbackend.dto.DanhSachSanPhamOkDtoNVLT;
import com.example.doanbackend.dto.page.PageDanhSachSanPhamOKNVLT;
import com.example.doanbackend.dto.page.PageSanPhamChuaSua;
import com.example.doanbackend.dto.SanPhamChuaSuaDto;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.entity.ThongTinSuaChua;
import com.example.doanbackend.entity.User;
import com.example.doanbackend.request.CapNhatThongTinNhanVienSuaChua;
import com.example.doanbackend.service.jpaservice.EntitySanPhamService;
import com.example.doanbackend.service.jpaservice.EntityThongTinSuaChuaService;
import com.example.doanbackend.service.jpaservice.EntityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SanPhamLTService {

    @Autowired
    private EntitySanPhamService entitySanPhamService;
    @Autowired
    private EntityUserService entityUserService;
    @Autowired
    private EntityThongTinSuaChuaService thongTinSuaChuaService;

    public PageSanPhamChuaSua layDanhSachSanPhamMoiDangKy(int page, int pageSize) {
        Page<SanPhamChuaSuaDto> sanPhamChuaSuaDtos = entitySanPhamService.layDanhSachSanPhamChuaSuaChua(page,pageSize);
        return new PageSanPhamChuaSua(
                sanPhamChuaSuaDtos.getNumber() + 1,
                sanPhamChuaSuaDtos.getSize(),
                sanPhamChuaSuaDtos.getTotalPages(),
                (int) Math.ceil(sanPhamChuaSuaDtos.getTotalElements()),
                sanPhamChuaSuaDtos.getContent()
        );
    }


    // lấy chi tiết 1 san phẩm theo id
    public SanPhamChuaSuaDto layChiTietSanPhamTheoId(Integer id) {
        return entitySanPhamService.layChiTietSanPhamTheoId(id);
    }

    public String capNhatThongTinNhanVienSuaChua(CapNhatThongTinNhanVienSuaChua capNhatThongTinNhanVienSuaChua, Integer id) {



        User user = entityUserService.findByMaNhanVien(capNhatThongTinNhanVienSuaChua.getMaNhanVien());

        ThongTinSuaChua thongTinSuaChua = ThongTinSuaChua.builder()
                .nhanVienSuaChua(user)
                .build();

        SanPham sanPham = entitySanPhamService.layRaSanPhamTheoId(id);
        if (sanPham.getThongTinSuaChua() != null) {
            return "Sản Phẩm đã đăng ký người sửa";
        }

        thongTinSuaChuaService.save(thongTinSuaChua);


        sanPham.setThongTinSuaChua(thongTinSuaChua);

        entitySanPhamService.save(sanPham);

        return "Đăng ký nhân viên sửa chữa thành công";
    }

    public PageDanhSachSanPhamOKNVLT danhSachSanPhamDaSuaChuaOK(int page, int pageSize) {
        String trangThai = "OK";
        Page<DanhSachSanPhamOkDtoNVLT> sanPhams = entitySanPhamService.danhSachSanPhamDaSuaChuaOK_NVLT(page,pageSize,trangThai);
        return new PageDanhSachSanPhamOKNVLT(
                sanPhams.getNumber() + 1,
                sanPhams.getSize(),
                sanPhams.getTotalPages(),
                (int) Math.ceil(sanPhams.getTotalElements()),
                sanPhams.getContent()
        );
    }
}
