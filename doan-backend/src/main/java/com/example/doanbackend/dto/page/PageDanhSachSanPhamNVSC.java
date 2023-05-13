package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.DanhSachSanPhamNVSCDto;
import com.example.doanbackend.dto.SanPhamChuaSuaDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDanhSachSanPhamNVSC {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<DanhSachSanPhamNVSCDto> data;
}
