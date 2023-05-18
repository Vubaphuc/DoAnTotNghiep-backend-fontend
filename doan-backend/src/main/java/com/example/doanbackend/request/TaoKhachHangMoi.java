package com.example.doanbackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaoKhachHangMoi {
    private String fullNameKH;
    private String phoneKH;
    private String emailKH;
    private String addressKH;
}
