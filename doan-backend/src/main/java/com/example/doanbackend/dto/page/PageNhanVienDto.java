package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.LinhKienDto;
import com.example.doanbackend.dto.NhanVienDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageNhanVienDto {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<NhanVienDto> data;
}
