package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.dto.BaoHanhDto;
import com.example.doanbackend.dto.SanPhamBaoHanhDto;
import com.example.doanbackend.dto.SanPhamChuaSuaDto;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.entity.ThongTinBaoHanh;
import org.springframework.data.domain.Page;

public interface IThongTinBaoHanhService {
    void save (ThongTinBaoHanh thongTinBaoHanh);

    Page<SanPhamBaoHanhDto> danhSachSanPhamBaoHanhPending(int page, int pageSize, String term);

    Page<SanPhamBaoHanhDto> danhSachSanPhamBaoHanhOk(int page, int pageSize, String term);

    Page<SanPhamBaoHanhDto> danhSachSanPhamBaoHanhTatCa(int page, int pageSize, String term);
    BaoHanhDto sanPhamBaoHanhTheoId(Integer id);

    ThongTinBaoHanh sanPhamFindById(Integer id);
}
