package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.HistoryMaterialDto;
import com.example.doanbackend.dto.HistoryNhanVienLeTanDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageHistoryMaterial {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<HistoryMaterialDto> data;
}
