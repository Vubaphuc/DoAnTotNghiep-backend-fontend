package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.HistoryNhanVienLeTanDto;
import com.example.doanbackend.dto.HistoryOrderMaterial;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageHistoryOrderMaterial {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<HistoryOrderMaterial> data;
}
