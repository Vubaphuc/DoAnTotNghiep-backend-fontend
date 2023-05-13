package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.DanhSachSanPhamOkDtoNVLT;
import com.example.doanbackend.dto.DanhSachStatusOrderNVSC;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDanhSachStatusOrderNVSC {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<DanhSachStatusOrderNVSC> data;
}
