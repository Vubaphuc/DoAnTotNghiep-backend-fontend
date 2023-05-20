package com.example.doanbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThongTinBaoHanhKhongTinhPhi {
    private Integer id;
    private String tenLoi;
    private String nguyenNhanLoi;
}
