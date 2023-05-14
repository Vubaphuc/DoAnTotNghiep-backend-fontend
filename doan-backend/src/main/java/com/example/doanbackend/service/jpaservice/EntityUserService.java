package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.dto.NhanVienDto;
import com.example.doanbackend.dto.userdto.NhanVienSuaChuaDto;
import com.example.doanbackend.dto.userdto.UserDto;
import com.example.doanbackend.entity.User;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.UserRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityUserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateById(Integer id) {
        User user = userRepository.findUsersById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy User có id = " + id);
        });
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteById(Integer id) {
        User user = userRepository.findUsersById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy User có id = " + id);
        });

        userRepository.deleteById(user.getId());
        return user;
    }

    @Override
    public User timKiemUserBangEmail(String email) {
        return userRepository.findUsersByEmail(email).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy User có email là " + email);
        });
    }

    @Override
    public List<NhanVienSuaChuaDto> layDanhSachNhanVienSuaChua() {
        return userRepository.layDanhSachNhanVienSuaChua("Nhân Viên Sửa Chữa");
    }

    @Override
    public User findByMaNhanVien(String maNhanVien) {
        return userRepository.findByMaNhanVien(maNhanVien).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy nhân viên nào có mã nhân viên là " + maNhanVien);
        });
    }

    @Override
    public Page<NhanVienDto> danhSachNhanVienLeTanCoPhanTrang(int page, int pageSize) {
        return userRepository.danhSachNhanVienLeTanCoPhanTrang(PageRequest.of(page - 1, pageSize));
    }
}
