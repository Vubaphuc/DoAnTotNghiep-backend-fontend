package com.example.doanbackend.dto.page;

import com.example.doanbackend.dto.HistoryCustomerDto;
import com.example.doanbackend.dto.HistoryMaterialDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageHistoryCustomer {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<HistoryCustomerDto> data;
}
