package com.example.doanbackend.service.nhanvienletanservice.sanpham;

import com.example.doanbackend.config.GenerateCode;
import com.example.doanbackend.dto.DanhSachSanPhamOkDtoNVLT;
import com.example.doanbackend.dto.HistoryNhanVienLeTanDto;
import com.example.doanbackend.dto.SanPhamDto;
import com.example.doanbackend.dto.page.PageDanhSachSanPhamOKNVLT;
import com.example.doanbackend.dto.page.PageHistoryNhanVienLeTanDto;
import com.example.doanbackend.dto.page.PageSanPhamChuaSua;
import com.example.doanbackend.dto.SanPhamChuaSuaDto;
import com.example.doanbackend.entity.*;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.mapper.SanPhamMapper;
import com.example.doanbackend.request.CapNhatThongTinNhanVienSuaChua;
import com.example.doanbackend.request.TaoMoiHoaDon;
import com.example.doanbackend.request.TaoSanPhamMoi;
import com.example.doanbackend.response.StatusResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamLTService {

    @Autowired
    private EntitySanPhamService entitySanPhamService;
    @Autowired
    private EntityUserService entityUserService;
    @Autowired
    private EntityThongTinSuaChuaService thongTinSuaChuaService;
    @Autowired
    private EntityKhachHangService entityKhachHangService;
    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;
    @Autowired
    private EntityThongTinLeTan entityThongTinLeTan;
    @Autowired
    private GenerateCode generateCode;
    @Autowired
    private EntityBaoHanhService entityBaoHanhService;
    @Autowired
    private EntityHoaDonService entityHoaDonService;



    public PageSanPhamChuaSua layDanhSachSanPhamMoiDangKy(int page, int pageSize,String term) {
        Page<SanPhamChuaSuaDto> sanPhamChuaSuaDtos = entitySanPhamService.layDanhSachSanPhamChuaSuaChua(page,pageSize,term);
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

    public StatusResponse capNhatThongTinNhanVienSuaChua(CapNhatThongTinNhanVienSuaChua capNhatThongTinNhanVienSuaChua, Integer id) {



        User user = entityUserService.findByMaNhanVien(capNhatThongTinNhanVienSuaChua.getMaNhanVien());
        SanPham sanPham = entitySanPhamService.layRaSanPhamTheoId(id);

        ThongTinSuaChua thongTinSuaChua = ThongTinSuaChua.builder()
                .sanPham(sanPham)
                .nhanVienSuaChua(user)
                .build();

        thongTinSuaChuaService.save(thongTinSuaChua);




        return new StatusResponse(200,"Đăng Ký Thành Công");

    }

    public PageDanhSachSanPhamOKNVLT danhSachSanPhamDaSuaChuaOK(int page, int pageSize, String term) {
        Page<DanhSachSanPhamOkDtoNVLT> sanPhams = entitySanPhamService.danhSachSanPhamDaSuaChuaOK_NVLT(page,pageSize,term);
        return new PageDanhSachSanPhamOKNVLT(
                sanPhams.getNumber() + 1,
                sanPhams.getSize(),
                sanPhams.getTotalPages(),
                (int) Math.ceil(sanPhams.getTotalElements()),
                sanPhams.getContent()
        );
    }

    public PageHistoryNhanVienLeTanDto timKiemLichSuSanPhamTheoTerm(int page, int pageSize, String term) {
        if (term == null || term.trim().isEmpty()) {
            return new PageHistoryNhanVienLeTanDto(
                    0,0,0,0,new ArrayList<>()
            );
        }
        Page<HistoryNhanVienLeTanDto> nhanVienLeTanDtos = entitySanPhamService.timKiemLichSuSanPhamTheoTerm(page,pageSize,term);
        return new PageHistoryNhanVienLeTanDto(
                nhanVienLeTanDtos.getNumber() + 1,
                nhanVienLeTanDtos.getSize(),
                nhanVienLeTanDtos.getTotalPages(),
                (int) Math.ceil(nhanVienLeTanDtos.getTotalElements()),
                nhanVienLeTanDtos.getContent()
        );
    }
    // tạo sản phẩm mới
    public SanPhamDto dangKySanPhamMoi(TaoSanPhamMoi taoSanPhamMoi) {

        KhachHang khachHang = entityKhachHangService.findById(taoSanPhamMoi.getId());

        SanPham sanPham = SanPham.builder()
                .hangSanXuat(taoSanPhamMoi.getHangSanPham())
                .model(taoSanPhamMoi.getModel())
                .IME(taoSanPhamMoi.getSoIME())
                .tenLoi(taoSanPhamMoi.getTenLoi())
                .giaTien(taoSanPhamMoi.getGiaTien())
                .thanhTien(taoSanPhamMoi.getGiaTien() * 1)
                .khachHang(khachHang)
                .build();
        entitySanPhamService.save(sanPham);


        ThongTinLeTan thongTinLeTan = ThongTinLeTan.builder()
                .sanPham(sanPham)
                .nhanVienLeTan(iCurrentUserLmpl.getUser())
                .build();
        entityThongTinLeTan.save(thongTinLeTan);

        return SanPhamMapper.toSanPhamDto(sanPham);
    }

    public StatusResponse taoHoaDonMoi(TaoMoiHoaDon taoMoiHoaDon) {
        // lấy ra sản phẩm
        SanPham sanPham = entitySanPhamService.findById(taoMoiHoaDon.getId());
        if (sanPham.getHoaDon() != null) {
            throw new BadRequestException("Sản Phẩm Đã Tạo Hóa Đơn");
        }
        // lấy ra linh kiện theo sản phẩm
//        LinhKien linhKien = sanPham.getThongTinSuaChua().getLinhKien();
        // lấy ra khách hàng theo sản phẩm
        KhachHang khachHang = sanPham.getKhachHang();
        // lấy ra tài khoản đang login
        User user = iCurrentUserLmpl.getUser();
        // tạo hóa đơn
        HoaDon hoaDon = HoaDon.builder()
                .maHoaDon(generateCode.generateCode())
                .soLuong(sanPham.getSoLuong())
                .thanhTien(sanPham.getThanhTien())
                .khachHang(khachHang)
                .sanPhams(List.of(sanPham))
                .nguoiTaoHoaDon(user)
                .build();
        // lưu hóa đơn lên csdl
        entityHoaDonService.save(hoaDon);
        //lưu lại hóa đơn vào sản phẩm
        sanPham.setHoaDon(hoaDon);
        // lưu lại lên csdl
        entitySanPhamService.save(sanPham);
        // tạo bảo hành
        BaoHanh baoHanh = BaoHanh.builder()
                .maSoBaoHanh(generateCode.generateCode())
//                .linhKien(linhKien)
                .khachHang(khachHang)
                .sanPham(sanPham)
                .nguoiKichHoatBaoHanh(user)
                .build();
        // lưu bảo hành vào csdl
        entityBaoHanhService.save(baoHanh);


        return new StatusResponse(200,"Tạo hóa đơn Thành công");
    }
}
