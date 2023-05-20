package com.example.doanbackend.repository;

import com.example.doanbackend.dto.BaoHanhDto;
import com.example.doanbackend.dto.SanPhamBaoHanhDto;
import com.example.doanbackend.dto.SanPhamChuaSuaDto;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.entity.ThongTinBaoHanh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ThongTinBaoHanhRepository extends JpaRepository<ThongTinBaoHanh, Integer> {


    @Query("select new com.example.doanbackend.dto.SanPhamBaoHanhDto(s.id, s.model, s.hangSanXuat, s.IME, ttbh.tenLoi, kh.fullName, kh.phoneNumber, ttbh.LoaiBaoHanh, ttbh.isStatus) " +
            "from ThongTinBaoHanh ttbh " +
            "left join SanPham s on s.id = ttbh.sanPham.id " +
            "left join KhachHang kh on kh.id = s.khachHang.id " +
            "where ttbh.isStatus = false and (s.IME like %?1%)")
    Page<SanPhamBaoHanhDto> danhSachSanPhamBaoHanhPending(Pageable pageable, String term);
    @Query("select new com.example.doanbackend.dto.SanPhamBaoHanhDto(s.id, s.model, s.hangSanXuat, s.IME, ttbh.tenLoi, kh.fullName, kh.phoneNumber, ttbh.LoaiBaoHanh, ttbh.isStatus) " +
            "from ThongTinBaoHanh ttbh " +
            "left join SanPham s on s.id = ttbh.sanPham.id " +
            "left join KhachHang kh on kh.id = s.khachHang.id " +
            "where ttbh.isStatus = true and (s.IME like %?1%)")
    Page<SanPhamBaoHanhDto> danhSachSanPhamBaoHanhOk(Pageable pageable, String term);
    @Query("select new com.example.doanbackend.dto.SanPhamBaoHanhDto(s.id, s.model, s.hangSanXuat, s.IME, ttbh.tenLoi, kh.fullName, kh.phoneNumber, ttbh.LoaiBaoHanh, ttbh.isStatus) " +
            "from ThongTinBaoHanh ttbh " +
            "left join SanPham s on s.id = ttbh.sanPham.id " +
            "left join KhachHang kh on kh.id = s.khachHang.id " +
            "where s.IME like %?1% ")
    Page<SanPhamBaoHanhDto> danhSachSanPhamBaoHanhTatCa(Pageable pageable, String term);

    @Query("select new com.example.doanbackend.dto.BaoHanhDto(ttbh.id , s.id, s.model, s.hangSanXuat, s.IME, ttbh.tenLoi, ttbh.isStatus ) from ThongTinBaoHanh ttbh " +
            "left join SanPham s on s.id = ttbh.sanPham.id " +
            "where ttbh.isStatus = false and s.id = ?1 ")
    Optional<BaoHanhDto> sanPhamBaoHanhTheoId(Integer id);

    Optional<ThongTinBaoHanh> findById(Integer id);
}