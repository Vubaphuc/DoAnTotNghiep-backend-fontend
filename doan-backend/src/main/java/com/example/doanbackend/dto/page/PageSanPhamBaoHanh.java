package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.HistoryOrderMaterial;
import com.example.doanbackend.dto.SanPhamBaoHanhDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageSanPhamBaoHanh {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<SanPhamBaoHanhDto> data;
}
