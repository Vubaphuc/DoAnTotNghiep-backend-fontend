package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.SanPhamChuaSuaDto;
import com.example.doanbackend.entity.SanPham;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageSanPhamChuaSua {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<SanPhamChuaSuaDto> data;
}
