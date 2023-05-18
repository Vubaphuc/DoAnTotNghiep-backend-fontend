package com.example.doanbackend.repository;

import com.example.doanbackend.dto.*;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {

    Optional<SanPham> findById(Integer id);

    Optional<SanPham> findByIME(String IME);


    @Query("select new com.example.doanbackend.dto.SanPhamChuaSuaDto(s.id, s.model, s.hangSanXuat, s.IME, s.tenLoi, s.trangThai) " +
            "from SanPham s " +
            "where s.thongTinSuaChua is null and ( s.model like %?1% or s.IME like %?1% )" +
            "order by s.thongTinLeTan.ngayNhanSanPham asc")
    Page<SanPhamChuaSuaDto> layDanhSachSanPhamChuaSuaChua(Pageable pageable,String term);

    @Query("select new com.example.doanbackend.dto.SanPhamChuaSuaDto(s.id, s.model, s.hangSanXuat, s.IME, s.tenLoi, s.trangThai) " +
            "from SanPham s " +
            "where s.id = ?1")
    Optional<SanPhamChuaSuaDto> layChiTietSanPhamTheoId(Integer id);


    @Query("select new com.example.doanbackend.dto.DanhSachSanPhamNVSCDto(s.id, s.model, s.hangSanXuat, s.IME, s.tenLoi, s.trangThai) " +
            "from SanPham s " +
            "where s.thongTinSuaChua.nhanVienSuaChua.id = ?1 and s.trangThai = false ")
    Page<DanhSachSanPhamNVSCDto> danhSachSanPhamDaPhatChoNguoiSuaChuaTheoIdNhanVien(Pageable pageable,Integer id);

    @Query("select new com.example.doanbackend.dto.DanhSachSanPhamNVSCDto(s.id, s.model, s.hangSanXuat, s.IME, s.tenLoi, s.trangThai) " +
            "from SanPham s " +
            "where s.id = ?1 and s.thongTinSuaChua.nhanVienSuaChua.id = ?2")
    Optional<DanhSachSanPhamNVSCDto> layChiTietSanPhamTheoId_NVSC(Integer sanPhamId, Integer nhanVienId);

    @Query("select new com.example.doanbackend.dto.DanhSachSanPhamOkDtoNVLT" +
            "(s.id,s.model,s.hangSanXuat,s.IME,s.tenLoi,s.thongTinSuaChua.linhKien.name,s.trangThai, s.soLuong,s.giaTien,s.thanhTien) " +
            "from SanPham s " +
            "where s.trangThai = true and s.isRepair = false and s.hoaDon = null and ( s.model like %?1% or s.IME like %?1% ) ")
    Page<DanhSachSanPhamOkDtoNVLT> danhSachSanPhamDaSuaChuaOK_NVLT(Pageable pageable, String term);


    @Query("select new com.example.doanbackend.dto.HoaDonSanPhamDto" +
            "(s.id ,s.khachHang.fullName, s.khachHang.phoneNumber, s.khachHang.email, s.hangSanXuat, s.model, s.IME,s.tenLoi,s.thongTinSuaChua.linhKien.name, s.thongTinSuaChua.linhKien.name, s.thongTinSuaChua.linhKien.thoiGianBaoHanh, s.soLuong,s.giaTien,s.thanhTien) " +
            "from SanPham s where s.trangThai = true and s.id = ?1")
    Optional<HoaDonSanPhamDto> chiTietSanPhamDaSuaOK(Integer id);


    @Query("select new com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT(kh.id,kh.maKhachHang, kh.fullName, kh.phoneNumber, kh.email,count (kh.id) ,s.trangThai) " +
            "from SanPham s " +
            "left join KhachHang kh on kh.id = s.khachHang.id " +
            "where s.trangThai = true and ( kh.fullName like %?1% or kh.phoneNumber like %?1% or kh.email like %?1% or kh.maKhachHang like %?1% ) " +
            "group by kh.id")
    Page<DanhSachKhachHangCoSanPhamNVLT> timKiemSanPhamTheoTenKhachHangOK(Pageable pageable,String term);

    @Query("select new com.example.doanbackend.dto.HistoryCustomerDto(kh.id, kh.maKhachHang, kh.fullName, kh.phoneNumber, kh.email, count (sp.id) ) " +
            "from KhachHang kh " +
            "left join SanPham sp on sp.khachHang.id = kh.id " +
            "where (kh.maKhachHang like %?1% or kh.phoneNumber like %?1% or kh.email like %?1% or kh.fullName like %?1% ) " +
            "group by kh.id ")
    Page<HistoryCustomerDto> timKiemSanPhamTheoTenKhachHangPending(Pageable pageable,String term);

    @Query("select new com.example.doanbackend.dto.HistoryNhanVienLeTanDto" +
            "(s.id," +
            "s.model, " +
            "s.hangSanXuat, " +
            "s.IME, " +
            "s.tenLoi, " +
            "s.trangThai, " +
            "u1.maNhanVien, " +
            "u1.fullName," +
            "ttlt.ngayNhanSanPham, " +
            "lk.name, " +
            "u2.maNhanVien, " +
            "u2.fullName, " +
            "ttsc.ngayHoanThanh," +
            "u3.maNhanVien, " +
            "u3.fullName, " +
            "hd.ngayTaoHoaDon," +
            " bh.maSoBaoHanh) " +
            "from SanPham s " +
            "left join BaoHanh bh on s.id = bh.sanPham.id " +
            "left join ThongTinLeTan ttlt on ttlt.id = s.thongTinLeTan.id " +
            "left join User u1 on u1.id = ttlt.nhanVienLeTan.id " +
            "left join ThongTinSuaChua ttsc on ttsc.id = s.thongTinSuaChua.id " +
            "left join LinhKien lk on lk.id = ttsc.linhKien.id " +
            "left join User u2 on u2.id = ttsc.nhanVienSuaChua.id " +
            "left join HoaDon hd on hd.id = s.hoaDon.id " +
            "left join User u3 on u3.id = hd.nguoiTaoHoaDon.id " +
            "where (s.IME like %?1% or u1.maNhanVien like %?1% or u1.fullName like %?1%)")
    Page<HistoryNhanVienLeTanDto> timKiemLichSuSanPhamTheoTerm(Pageable pageable, String term);

    @Query("select new com.example.doanbackend.dto.DanhSachSanPhamNVSCDto(s.id, s.model, s.hangSanXuat, s.IME, s.tenLoi, s.trangThai ) " +
            "from SanPham s " +
            "where s.khachHang.id = ?1")
    Page<DanhSachSanPhamNVSCDto> danhSachSanPhamTheoIdKKhachHang(Pageable pageable, Integer id);

    @Query("select new com.example.doanbackend.dto.HistoryProductDto" +
            "(s.id," +
            "s.model, " +
            "s.hangSanXuat, " +
            "s.IME, " +
            "s.tenLoi, " +
            "s.trangThai, " +
            "u1.maNhanVien, " +
            "u1.fullName," +
            "ttlt.ngayNhanSanPham, " +
            "lk.name, " +
            "u2.maNhanVien, " +
            "u2.fullName, " +
            "ttsc.ngayHoanThanh," +
            "u3.maNhanVien, " +
            "u3.fullName, " +
            "hd.ngayTaoHoaDon, " +
            "bh.maSoBaoHanh ," +
            "count (ttbh.id)) " +
            "from SanPham s " +
            "left join BaoHanh bh on s.id = bh.sanPham.id " +
            "left join ThongTinLeTan ttlt on ttlt.id = s.thongTinLeTan.id " +
            "left join User u1 on u1.id = ttlt.nhanVienLeTan.id " +
            "left join ThongTinSuaChua ttsc on ttsc.id = s.thongTinSuaChua.id " +
            "left join LinhKien lk on lk.id = ttsc.linhKien.id " +
            "left join User u2 on u2.id = ttsc.nhanVienSuaChua.id " +
            "left join HoaDon hd on hd.id = s.hoaDon.id " +
            "left join User u3 on u3.id = hd.nguoiTaoHoaDon.id " +
            "left join KhachHang  kh on kh.id = s.khachHang.id " +
            "left join ThongTinBaoHanh ttbh on s.id = ttbh.sanPham.id " +
            "where s.trangThai = true and s.hoaDon != null and s.IME like %?1% " +
            "group by " +
            "s.id," +
            "s.model, " +
            "s.hangSanXuat, " +
            "s.IME, " +
            "s.tenLoi, " +
            "s.trangThai, " +
            "u1.maNhanVien, " +
            "u1.fullName," +
            "ttlt.ngayNhanSanPham, " +
            "lk.name, " +
            "u2.maNhanVien, " +
            "u2.fullName, " +
            "ttsc.ngayHoanThanh," +
            "u3.maNhanVien, " +
            "u3.fullName, " +
            "hd.ngayTaoHoaDon, " +
            "bh.maSoBaoHanh ")
    Page<HistoryProductDto> searchHistoryProductByTerm(Pageable pageable, String term);


    @Query("select new com.example.doanbackend.dto.ProductCustomerDto(s.id, s.model, s.hangSanXuat, s.IME, kh.id, kh.fullName, kh.phoneNumber, kh.email, kh.address ) " +
            "from SanPham s " +
            "left join KhachHang kh on kh.id = s.khachHang.id " +
            "where s.id = ?1 and s.hoaDon != null ")
    Optional<ProductCustomerDto> findProductAndCustomerById(Integer id);
}