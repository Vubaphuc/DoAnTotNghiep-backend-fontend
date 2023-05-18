package com.example.doanbackend.repository;

import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import com.example.doanbackend.dto.HistoryOrderMaterial;
import com.example.doanbackend.dto.OrderDto;
import com.example.doanbackend.entity.OrderMaterial;
import com.example.doanbackend.entity.VatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface OrderMaterialRepository extends JpaRepository<OrderMaterial, Integer> {

    Optional<OrderMaterial> findById(Integer id);

    @Query("select new com.example.doanbackend.dto.DanhSachStatusOrderNVSC" +
            "(o.id, o.orderCode, o.material.code, o.material.tenModel, o.accessory.name, o.quantity, o.petitioner.maNhanVien, o.petitioner.fullName, o.isStatus) " +
            "from OrderMaterial o " +
            "where o.isStatus = true and o.petitioner.id = ?1 ")
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuOk_NVSC (Pageable pageable, Integer id);

    @Query("select new com.example.doanbackend.dto.DanhSachStatusOrderNVSC" +
            "(o.id, o.orderCode, o.material.code, o.material.tenModel, o.accessory.name, o.quantity, o.petitioner.maNhanVien, o.petitioner.fullName, o.isStatus) " +
            "from OrderMaterial o " +
            "where o.isStatus = false and o.petitioner.id = ?1 ")
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuPending_NVSC (Pageable pageable, Integer id);

    @Query("select new com.example.doanbackend.dto.OrderDto(o.id, o.orderCode,o.material.code, o.material.tenModel, o.accessory.name, o.quantity, o.isStatus) " +
            "from OrderMaterial o where o.id = ?1")
    Optional<OrderDto> chiTietOrderTheoId(Integer id);

   @Query("select new com.example.doanbackend.dto.DanhSachStatusOrderNVSC " +
            "(o.id, o.orderCode, o.material.code, o.material.tenModel, o.accessory.name, o.quantity, o.petitioner.maNhanVien, o.petitioner.fullName, o.isStatus) " +
           "from OrderMaterial o where o.isStatus = true and o.approver.id = ?1 ")
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuOk_NVK(Pageable pageable, Integer id);

    @Query("select new com.example.doanbackend.dto.DanhSachStatusOrderNVSC " +
            "(o.id, o.orderCode, o.material.code, o.material.tenModel, o.accessory.name, o.quantity, o.petitioner.maNhanVien, o.petitioner.fullName, o.isStatus) " +
            "from OrderMaterial o where o.isStatus = false ")
    Page<DanhSachStatusOrderNVSC> danhSachOrderVatLieuPending_NVK(Pageable pageable);

    @Query("select new com.example.doanbackend.dto.HistoryOrderMaterial(" +
            "o.id, o.orderCode, o.quantity, o.isStatus, u1.maNhanVien, u1.fullName, o.ngayOrder, u2.maNhanVien, u2.fullName, " +
            "o.ngayPheDuyet, lk.name, vl.code, vl.tenModel, vd.name ) " +
            "from OrderMaterial o " +
            "left join LinhKien lk on lk.id = o.accessory.id " +
            "left join VatLieu vl on vl.id = o.material.id " +
            "left join User u1 on u1.id = o.petitioner.id " +
            "left join User  u2 on u2.id = o.approver.id " +
            "left join Vendor vd on vd.id = vl.vendor.id " +
            "where o.orderCode like %?1% ")
    Page<HistoryOrderMaterial> timKiemOrderVatLieuTheoTerm(Pageable pageable, String term);
}