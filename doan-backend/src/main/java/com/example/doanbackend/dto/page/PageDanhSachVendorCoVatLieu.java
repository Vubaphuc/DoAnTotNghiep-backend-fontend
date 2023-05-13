package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.DanhSachVenderDto;
import com.example.doanbackend.entity.Vendor;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDanhSachVendorCoVatLieu {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<DanhSachVenderDto> data;
}
