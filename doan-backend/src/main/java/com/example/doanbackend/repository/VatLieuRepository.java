package com.example.doanbackend.repository;

import com.example.doanbackend.dto.*;
import com.example.doanbackend.entity.VatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VatLieuRepository extends JpaRepository<VatLieu, Integer> {

    Optional<VatLieu> findByCode(String code);

    @Query("select new com.example.doanbackend.dto.DanhSachVenderDto(vd.id, vd.name, count (vl.id)) " +
            "from VatLieu vl " +
            "left join vl.vendor vd " +
            "group by vd.id " +
            "having count (vl.id) > 0 " +
            "order by count (vl.id) desc")
    Page<DanhSachVenderDto> danhSachVenderCoTongSoVatLieuDangCo(Pageable pageable);

    @Query("select new com.example.doanbackend.dto.DanhSachVatLieuDto (vl.id,vl.code, vl.tenModel, vl.soLuong, vl.linhKien.name) " +
            "from VatLieu vl " +
            "where vl.soLuong > 0" +
            "order by vl.soLuong desc")
    Page<DanhSachVatLieuDto> danhSachVatLieuAll(Pageable pageable);

    @Query("select new com.example.doanbackend.dto.DanhSachVatLieuTheoVendorDto(vl.id,vl.code, vl.tenModel, vl.soLuong, vl.linhKien.name, vd.name) " +
            "from VatLieu vl " +
            "left join vl.vendor vd " +
            "where vd.id = :vendorId " +
            "order by vl.soLuong desc")
    Page<DanhSachVatLieuTheoVendorDto> danhSachVatLieuTheoVendor(Pageable pageable, @Param("vendorId") int vendorId);


    @Query("select new com.example.doanbackend.dto.VatLieuSuaChuaDto(vl.id,vl.code, vl.tenModel, vl.linhKien.name) from VatLieu vl where vl.code = ?1")
    Optional<VatLieuSuaChuaDto> layVatLieuTheoCode(String code);

    @Query("select new com.example.doanbackend.dto.VatLieuSuaChuaDto" +
            "(vl.id,vl.code, vl.tenModel, vl.linhKien.name) " +
            "from VatLieu vl " +
            "where vl.tenModel = :tenModel " +
            "and vl.linhKien.name = :tenLinhKien")
    List<VatLieuSuaChuaDto> danhSachVatLieuTheoModelVaLinhKien(@Param("tenModel") String tenModel, @Param("tenLinhKien") String tenLinhKien);

    @Query("select new com.example.doanbackend.dto.HistoryMaterialDto" +
            "(vl.id, vl.code, vl.tenModel, lk.name, vd.name, vl.soLuong, u.maNhanVien, u.fullName, vl.ngayTaoVatLieu, vl.ngayCapNhat) " +
            "from VatLieu vl " +
            "left join LinhKien lk on lk.id = vl.linhKien.id " +
            "left join Vendor vd on vd.id = vl.vendor.id " +
            "left join User u on u.id = vl.nhanVienNhap.id " +
            "where (vl.code like %?1% or vl.tenModel like %?1% )")
    Page<HistoryMaterialDto> searchHistoryMaterial(Pageable pageable, String term);
}