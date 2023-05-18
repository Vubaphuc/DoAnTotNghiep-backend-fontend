package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.dto.BaoHanhDto;
import com.example.doanbackend.dto.SanPhamBaoHanhDto;
import com.example.doanbackend.dto.SanPhamChuaSuaDto;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.entity.ThongTinBaoHanh;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.ThongTinBaoHanhRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IThongTinBaoHanhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EntityThongTinBaoHanhService implements IThongTinBaoHanhService {
    @Autowired
    private ThongTinBaoHanhRepository thongTinBaoHanhRepository;
    @Override
    public void save(ThongTinBaoHanh thongTinBaoHanh) {
        thongTinBaoHanhRepository.save(thongTinBaoHanh);
    }

    @Override
    public Page<SanPhamBaoHanhDto> danhSachSanPhamBaoHanhPending(int page, int pageSize, String term) {
        return thongTinBaoHanhRepository.danhSachSanPhamBaoHanhPending(PageRequest.of(page - 1, pageSize), term);
    }

    @Override
    public Page<SanPhamBaoHanhDto> danhSachSanPhamBaoHanhOk(int page, int pageSize, String term) {
        return thongTinBaoHanhRepository.danhSachSanPhamBaoHanhOk(PageRequest.of(page - 1, pageSize), term);
    }

    @Override
    public Page<SanPhamBaoHanhDto> danhSachSanPhamBaoHanhTatCa(int page, int pageSize, String term) {
        return thongTinBaoHanhRepository.danhSachSanPhamBaoHanhTatCa(PageRequest.of(page - 1, pageSize), term);
    }
    @Override
    public BaoHanhDto sanPhamBaoHanhTheoId(Integer id) {
        return thongTinBaoHanhRepository.sanPhamBaoHanhTheoId(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy sản phẩm có id là " + id);
        });
    }

    @Override
    public ThongTinBaoHanh sanPhamFindById(Integer id) {
        return thongTinBaoHanhRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy sản phẩm có id là " + id);
        });
    }
}
