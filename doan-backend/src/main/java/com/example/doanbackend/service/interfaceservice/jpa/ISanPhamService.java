package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT;
import com.example.doanbackend.dto.DanhSachSanPhamNVSCDto;
import com.example.doanbackend.dto.DanhSachSanPhamOkDtoNVLT;
import com.example.doanbackend.dto.SanPhamChuaSuaDto;
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

    SanPham xoaSanPhamTheoId(Integer id);

    Page<SanPhamChuaSuaDto> layDanhSachSanPhamChuaSuaChua (int page, int pageSize);

    SanPhamChuaSuaDto layChiTietSanPhamTheoId(Integer id);


    Page<DanhSachSanPhamNVSCDto> layDanhSachSanPhamPhanPhatChoUser(int page, int pageSize, Integer id);

    DanhSachSanPhamNVSCDto layChiTietSanPhamTheoId_NVSC(Integer sanPhamId, Integer nhanVienId);
    Page<DanhSachSanPhamOkDtoNVLT> danhSachSanPhamDaSuaChuaOK_NVLT(Integer page, Integer pageSize, String trangThai);


    Page<DanhSachKhachHangCoSanPhamNVLT> getDanhSachKhachHangCoSanPhamOK(Integer page, Integer pageSize);
    Page<DanhSachKhachHangCoSanPhamNVLT> getDanhSachKhachHangCoSanPhamPending(Integer page, Integer pageSize);

}
