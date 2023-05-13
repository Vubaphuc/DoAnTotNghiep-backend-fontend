package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.DanhSachSanPhamOkDtoNVLT;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDanhSachSanPhamOKNVLT {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<DanhSachSanPhamOkDtoNVLT> data;
}
