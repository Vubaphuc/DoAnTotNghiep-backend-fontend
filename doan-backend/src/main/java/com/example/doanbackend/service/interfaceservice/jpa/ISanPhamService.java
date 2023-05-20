package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.*;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISanPhamService {

    void save(SanPham sanPham);
    SanPham findById (Integer id);

    SanPham layRaSanPhamTheoId(Integer id);

    Page<SanPhamChuaSuaDto> layDanhSachSanPhamChuaSuaChua (int page, int pageSize,String term);

    SanPhamChuaSuaDto layChiTietSanPhamTheoId(Integer id);


    Page<DanhSachSanPhamNVSCDto> layDanhSachSanPhamPhanPhatChoUser(int page, int pageSize, Integer id);

    DanhSachSanPhamNVSCDto layChiTietSanPhamTheoId_NVSC(Integer sanPhamId, Integer nhanVienId);
    Page<DanhSachSanPhamOkDtoNVLT> danhSachSanPhamDaSuaChuaOK_NVLT(Integer page, Integer pageSize, String trangThai);

    HoaDonSanPhamDto layChiTietSanPhamOKTheoID(Integer id);

    Page<DanhSachKhachHangCoSanPhamNVLT> timKiemSanPhamTheoTenKhachHangOK(String tenKhachHang,int page,int pageSize);
    Page<HistoryCustomerDto> timKiemSanPhamTheoTenKhachHangPeding(int page,int pageSize, String term);
    Page<HistoryNhanVienLeTanDto> timKiemLichSuSanPhamTheoTerm(int page, int pageSize, String term);
    Page<DanhSachSanPhamNVSCDto> danhSachSanPhamTheoIdKKhachHang(int page, int pageSize, Integer id);
    Page<HistoryProductDto> searchHistoryProductByTerm(int page, int pageSize, String term);
    ProductCustomerDto findProductAndCustomerById(Integer id);


}
