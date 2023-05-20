package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.dto.*;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.SanPhamRepository;
import com.example.doanbackend.service.interfaceservice.jpa.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntitySanPhamService implements ISanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public void save(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham findById(Integer id) {
        return sanPhamRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy sản phẩm có id là " + id);
        });
    }

    @Override
    public SanPham layRaSanPhamTheoId(Integer id) {
        return sanPhamRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy sản phẩm có id là " + id);
        });
    }

    @Override
    public Page<SanPhamChuaSuaDto> layDanhSachSanPhamChuaSuaChua(int page, int pageSize, String term) {
        return sanPhamRepository.layDanhSachSanPhamChuaSuaChua(PageRequest.of(page - 1, pageSize), term);
    }


    @Override
    public SanPhamChuaSuaDto layChiTietSanPhamTheoId(Integer id) {
        return sanPhamRepository.layChiTietSanPhamTheoId(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy sản phẩm nào có id là " + id);
        });
    }

    @Override
    public Page<DanhSachSanPhamNVSCDto> layDanhSachSanPhamPhanPhatChoUser(int page, int pageSize, Integer id) {
        return sanPhamRepository.danhSachSanPhamDaPhatChoNguoiSuaChuaTheoIdNhanVien(PageRequest.of(page - 1, pageSize),id);
    }

    @Override
    public DanhSachSanPhamNVSCDto layChiTietSanPhamTheoId_NVSC(Integer sanPhamId, Integer nhanVienId) {
        return sanPhamRepository.layChiTietSanPhamTheoId_NVSC(sanPhamId,nhanVienId).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy sản phẩm nào");
        });
    }

    @Override
    public Page<DanhSachSanPhamOkDtoNVLT> danhSachSanPhamDaSuaChuaOK_NVLT(Integer page, Integer pageSize, String term) {
        return sanPhamRepository.danhSachSanPhamDaSuaChuaOK_NVLT(PageRequest.of(page - 1, pageSize), term);
    }

    @Override
    public HoaDonSanPhamDto layChiTietSanPhamOKTheoID(Integer id) {
        return sanPhamRepository.chiTietSanPhamDaSuaOK(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy sản phẩm OK nào có id là " + id);
        });
    }
    @Override
    public Page<DanhSachKhachHangCoSanPhamNVLT> timKiemSanPhamTheoTenKhachHangOK(String term,int page,int pageSize) {
        return sanPhamRepository.timKiemSanPhamTheoTenKhachHangOK(PageRequest.of(page - 1, pageSize),term);
    }

    @Override
    public Page<HistoryCustomerDto> timKiemSanPhamTheoTenKhachHangPeding( int page, int pageSize, String term) {
        return sanPhamRepository.timKiemSanPhamTheoTenKhachHangPending(PageRequest.of(page - 1,pageSize),term);
    }

    @Override
    public Page<HistoryNhanVienLeTanDto> timKiemLichSuSanPhamTheoTerm(int page, int pageSize, String term) {
        return sanPhamRepository.timKiemLichSuSanPhamTheoTerm(PageRequest.of(page - 1, pageSize), term);
    }
    @Override
    public Page<DanhSachSanPhamNVSCDto> danhSachSanPhamTheoIdKKhachHang(int page, int pageSize, Integer id) {
        return sanPhamRepository.danhSachSanPhamTheoIdKKhachHang(PageRequest.of(page - 1, pageSize), id);
    }
    @Override
    public Page<HistoryProductDto> searchHistoryProductByTerm(int page, int pageSize, String term) {
        return sanPhamRepository.searchHistoryProductByTerm(PageRequest.of(page - 1, pageSize), term);
    }
    @Override
    public ProductCustomerDto findProductAndCustomerById(Integer id) {
        return sanPhamRepository.findProductAndCustomerById(id).orElseThrow(() -> {
            throw new NotFoundException("Not Found with id: " + id);
        });
    }
}
