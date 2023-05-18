package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.HistoryProductDto;
import com.example.doanbackend.dto.LinhKienDto;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageHistoryProduct {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<HistoryProductDto> data;
}
