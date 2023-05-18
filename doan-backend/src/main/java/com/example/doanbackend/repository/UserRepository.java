package com.example.doanbackend.repository;

import com.example.doanbackend.dto.NhanVienDto;
import com.example.doanbackend.dto.userdto.NhanVienSuaChuaDto;
import com.example.doanbackend.dto.userdto.UserDto;
import com.example.doanbackend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUsersByEmail(String email);
    Optional<User> findUsersById(Integer id);
    Optional<User> findByMaNhanVien(String maNhanVien);

    @Query("select new com.example.doanbackend.dto.userdto.NhanVienSuaChuaDto(u.id, u.maNhanVien, u.fullName) " +
            "from User u join u.roles rl " +
            "where rl.name = 'NHANVIENSUACHUA' ")
    List<NhanVienSuaChuaDto> layDanhSachNhanVienSuaChua();

    @Query("select new com.example.doanbackend.dto.NhanVienDto(u.id,u.maNhanVien, u.fullName) from User u left join u.roles rl where rl.name = 'NHANVIENSUACHUA'")
    Page<NhanVienDto> danhSachNhanVienSuaChuaCoPhanTrang(Pageable pageable);


}