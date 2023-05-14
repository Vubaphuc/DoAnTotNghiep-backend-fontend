package com.example.doanbackend.repository;

import com.example.doanbackend.dto.*;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    Optional<SanPham> findById(Integer id);

    Optional<SanPham> findByIME(String IME);


    @Query("select new com.example.doanbackend.dto.SanPhamChuaSuaDto(s.id, s.model, s.hangSanXuat, s.IME, s.tenLoi) " +
            "from SanPham s " +
            "where s.thongTinSuaChua is null " +
            "order by s.thongTinLeTan.ngayNhanSanPham asc")
    Page<SanPhamChuaSuaDto> layDanhSachSanPhamChuaSuaChua(Pageable pageable);

    @Query("select new com.example.doanbackend.dto.SanPhamChuaSuaDto(s.id, s.model, s.hangSanXuat, s.IME, s.tenLoi) " +
            "from SanPham s " +
            "where s.id = ?1")
    Optional<SanPhamChuaSuaDto> layChiTietSanPhamTheoId(Integer id);


    @Query("select new com.example.doanbackend.dto.DanhSachSanPhamNVSCDto(s.id, s.model, s.hangSanXuat, s.IME, s.tenLoi, s.trangThai) " +
            "from SanPham s " +
            "where s.thongTinSuaChua.nhanVienSuaChua.id = :id and s.trangThai = :trangThai")
    Page<DanhSachSanPhamNVSCDto> danhSachSanPhamDaPhatChoNguoiSuaChuaTheoIdNhanVien(Pageable pageable, @Param("id") Integer id, @Param("trangThai") String trangThai);

    @Query("select new com.example.doanbackend.dto.DanhSachSanPhamNVSCDto(s.id, s.model, s.hangSanXuat, s.IME, s.tenLoi, s.trangThai) " +
            "from SanPham s " +
            "where s.id = ?1 and s.thongTinSuaChua.nhanVienSuaChua.id = ?2")
    Optional<DanhSachSanPhamNVSCDto> layChiTietSanPhamTheoId_NVSC(Integer sanPhamId, Integer nhanVienId);


    @Query("select new com.example.doanbackend.dto.DanhSachSanPhamOkDtoNVLT" +
            "(s.id,s.model,s.hangSanXuat,s.IME,s.tenLoi,s.thongTinSuaChua.viTriSua,s.trangThai, s.soLuong,s.giaTien,s.thanhTien) " +
            "from SanPham s " +
            "where s.trangThai = :trangThai and s.hoaDon = null ")
    Page<DanhSachSanPhamOkDtoNVLT> danhSachSanPhamDaSuaChuaOK_NVLT(Pageable pageable, @Param("trangThai") String trangThai);


    @Query("select new com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT" +
            "(s.khachHang.maKhachHang, s.khachHang.fullName,s.khachHang.phoneNumber,s.khachHang.email,count (s),s.trangThai) " +
            "from SanPham s " +
            "where s.trangThai = 'PENDING' " +
            "group by s.khachHang")
    Page<DanhSachKhachHangCoSanPhamNVLT> getDanhSachKhachHangCoSanPhamPending(Pageable pageable);

    @Query("select new com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT" +
            "(s.khachHang.maKhachHang, s.khachHang.fullName,s.khachHang.phoneNumber,s.khachHang.email,count (s),s.trangThai) " +
            "from SanPham s " +
            "where s.trangThai = 'OK' " +
            "group by s.khachHang")
    Page<DanhSachKhachHangCoSanPhamNVLT> getDanhSachKhachHangCoSanPhamOK(Pageable pageable);

    @Query("select new com.example.doanbackend.dto.HoaDonSanPhamDto" +
            "(s.id ,s.khachHang.fullName, s.khachHang.phoneNumber, s.khachHang.email, s.hangSanXuat, s.model, s.IME,s.tenLoi,s.thongTinSuaChua.viTriSua, s.thongTinSuaChua.linhKien.name, s.thongTinSuaChua.linhKien.thoiGianBaoHanh, s.soLuong,s.giaTien,s.thanhTien) " +
            "from SanPham s where s.trangThai = 'OK' and s.id = ?1")
    Optional<HoaDonSanPhamDto> chiTietSanPhamDaSuaOK(Integer id);


    @Query("select new com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT(kh.maKhachHang, kh.fullName, kh.phoneNumber, kh.email,count (kh.id) ,s.trangThai) " +
            "from SanPham s " +
            "join s.khachHang kh " +
            "where s.trangThai = 'OK' and kh.fullName like %?1% " +
            "group by kh.id")
    Page<DanhSachKhachHangCoSanPhamNVLT> timKiemSanPhamTheoTenKhachHangOK(Pageable pageable,String tenKhachHang);

    @Query("select new com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT(kh.maKhachHang, kh.fullName, kh.phoneNumber, kh.email,count (kh.id) ,s.trangThai) " +
            "from SanPham s " +
            "join s.khachHang kh " +
            "where s.trangThai = 'PENDING' and kh.fullName like %?1% " +
            "group by kh.id")
    Page<DanhSachKhachHangCoSanPhamNVLT> timKiemSanPhamTheoTenKhachHangPending(Pageable pageable,String tenKhachHang);

}