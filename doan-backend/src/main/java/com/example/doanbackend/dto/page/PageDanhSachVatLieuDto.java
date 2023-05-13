package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.DanhSachVatLieuDto;
import com.example.doanbackend.dto.DanhSachVenderDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDanhSachVatLieuDto {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<DanhSachVatLieuDto> data;
}
