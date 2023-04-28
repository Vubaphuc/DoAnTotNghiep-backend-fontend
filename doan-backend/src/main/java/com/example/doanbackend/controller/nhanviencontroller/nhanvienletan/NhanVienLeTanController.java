package com.example.doanbackend.controller.nhanviencontroller.nhanvienletan;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NhanVienLeTanController {

    // nhập thông tin sản phẩm
    @PostMapping("/")
    public ResponseEntity<?> taoThongTinKhachHang() {
        return null;
    }
    // nhập thông tin khách hàng
    // làm hóa đơn
    // làm phiếu bảo hành
    // sửa thông tin sản phẩm
    // sửa thông tin khách hàng
    // sửa hóa đơn
    // sửa phiếu bảo hành
    // xóa hóa đơn // không xóa mà chuyển sang trạng thái hủy/ pending/ ok
    // xóa sản phẩm // kiểm tra sản phẩm có đã vào trong cửa hàngchuawaw. nếu chưa mới được xóa còn lại không đượcp phép xóa
    // xóa khách hàng // kiểm tra


}
