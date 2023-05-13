package com.example.doanbackend.service.nhanvienletanservice.khachhang;

import com.example.doanbackend.config.GenerateCode;
import com.example.doanbackend.dto.DanhSachKhachHangCoSanPhamNVLT;
import com.example.doanbackend.dto.page.PageDanhSachKhachHangCoSanPham;
import com.example.doanbackend.dto.page.PageDanhSachSanPhamOKNVLT;
import com.example.doanbackend.entity.KhachHang;
import com.example.doanbackend.entity.SanPham;
import com.example.doanbackend.repository.SanPhamRepository;
import com.example.doanbackend.request.KhachHangDangKyMoi;
import com.example.doanbackend.service.jpaservice.EntityKhachHangService;
import com.example.doanbackend.service.jpaservice.EntitySanPhamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.doanbackend.config.SecurityConfig;

import java.util.List;

@Service
public class KhachHangService {

    @Autowired
    private EntitySanPhamService entitySanPhamService;




    // danh sách khách hàng có sản phẩm sửa chữa ok
    public PageDanhSachKhachHangCoSanPham danhSachKhachHangCoSanPhamOk(int page, int pageSize) {

        Page<DanhSachKhachHangCoSanPhamNVLT> sanPhams = entitySanPhamService.getDanhSachKhachHangCoSanPhamOK(page,pageSize);

        return new PageDanhSachKhachHangCoSanPham(
                sanPhams.getNumber() + 1,
                sanPhams.getSize(),
                sanPhams.getTotalPages(),
                (int) Math.ceil(sanPhams.getTotalElements()),
                sanPhams.getContent()
        );
    }

    // danh sách khách hàng có sản phẩm sửa chữa đang Pending
    public PageDanhSachKhachHangCoSanPham danhSachKhachHangCoSanPhamPeding(int page, int pageSize) {

        Page<DanhSachKhachHangCoSanPhamNVLT> sanPhams = entitySanPhamService.getDanhSachKhachHangCoSanPhamPending(page,pageSize);

        return new PageDanhSachKhachHangCoSanPham(
                sanPhams.getNumber() + 1,
                sanPhams.getSize(),
                sanPhams.getTotalPages(),
                (int) Math.ceil(sanPhams.getTotalElements()),
                sanPhams.getContent()
        );
    }
}
