package com.example.doanbackend.repository;

import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.entity.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OderRepository extends JpaRepository<Oder, Integer> {

    @Query("select new com.example.doanbackend.dto.DanhSachStatusOrderNVSC " +
            "(o.id, o.maOder, vl.code, vl.tenModel, o.linhKien.name, o.soLuong, o.nhanVienOder.maNhanVien, o.nhanVienOder.fullName, o.isStatus) " +
            "from Oder o left join o.vatLieus vl where o.isStatus = true and o.nhanVienOder.maNhanVien = :maNhanVien")
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuThanhCong(Pageable pageable,@Param("maNhanVien") String maNhanVien);

    @Query("select new com.example.doanbackend.dto.DanhSachStatusOrderNVSC " +
            "(o.id, o.maOder, vl.code, vl.tenModel, o.linhKien.name, o.soLuong, o.nhanVienOder.maNhanVien, o.nhanVienOder.fullName, o.isStatus) " +
            "from Oder o left join o.vatLieus vl where o.isStatus = false and o.nhanVienOder.maNhanVien = :maNhanVien")
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuPending(Pageable pageable,@Param("maNhanVien") String maNhanVien);
}