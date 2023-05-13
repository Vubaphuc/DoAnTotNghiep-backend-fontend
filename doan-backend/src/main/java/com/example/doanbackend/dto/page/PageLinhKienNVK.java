package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.LinhKienDto;
import com.example.doanbackend.dto.SanPhamChuaSuaDto;
import com.example.doanbackend.entity.LinhKien;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageLinhKienNVK {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<LinhKienDto> data;
}
