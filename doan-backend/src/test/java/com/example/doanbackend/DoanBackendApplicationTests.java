package com.example.doanbackend;

import com.example.doanbackend.config.GenerateCode;
import com.example.doanbackend.entity.*;
import com.example.doanbackend.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class DoanBackendApplicationTests {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private GenerateCode generateCode;
    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    private LinhKienRepository linhKienRepository;
    @Autowired
    private VatLieuRepository vatLieuRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private ThongTinLeTanRepository thongTinLeTanRepository;
    @Autowired
    private ThongTinSuaChuaRepository thongTinSuaChuaRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Test
    void save_roles() {
        List<Role> roles = List.of(
                new Role(null, "NHANVIENLETAN"),
                new Role(null, "NHANVIENKHO"),
                new Role(null, "NHANVIENSUACHUA"),
                new Role(null, "NHANVIENBAOHANH"),
                new Role(null, "ADMIN")
        );

        roleRepository.saveAll(roles);
    }




    @Test
    void save_users () {

        Role khoRole = roleRepository.findRoleByName("NHANVIENKHO").orElse(null);
        Role baoHanhRole = roleRepository.findRoleByName("NHANVIENBAOHANH").orElse(null);
        Role suaChuaRole = roleRepository.findRoleByName("NHANVIENSUACHUA").orElse(null);
        Role leTanRole = roleRepository.findRoleByName("NHANVIENLETAN").orElse(null);
        Role ADMINRole = roleRepository.findRoleByName("ADMIN").orElse(null);

        List<User> users = List.of(
                new User(null, generateCode.generateCode(),"Diệu Linh", "linh@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(khoRole)),
                new User(null, generateCode.generateCode(),"Bá Hậu", "hau@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(baoHanhRole)),
                new User(null, generateCode.generateCode(),"Bá Phúc", "phuc@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(ADMINRole)),
                new User(null, generateCode.generateCode(),"Giáp Nhàn", "nhan@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(leTanRole)),
                new User(null, generateCode.generateCode(),"Đăng Quang", "quang@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(suaChuaRole)),
                new User(null, generateCode.generateCode(),"Phùng Văn Tài", "tai@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(suaChuaRole))
        );

        userRepository.saveAll(users);

    }

    @Test
    void save_linhKien () {

        User user = userRepository.findById(1).orElse(null);

        List<Vendor> vendors = List.of(
                new Vendor(null,"QUALCOMM",user),
                new Vendor(null,"MEDIAMART",user),
                new Vendor(null,"SHANNON",user),
                new Vendor(null,"SAMSUNG",user)
        );

        vendorRepository.saveAll(vendors);

        List<LinhKien> linhKiens = List.of(
                new LinhKien(null,"LCD",12,user),
                new LinhKien(null,"BackGlass",12,user),
                new LinhKien(null,"Rear",12,user),
                new LinhKien(null,"PIN",12,user),
                new LinhKien(null,"FRONT",12,user),
                new LinhKien(null,"PBA",12,user),
                new LinhKien(null,"Sub PBA",12,user),
                new LinhKien(null,"SPK",12,user),
                new LinhKien(null,"Camera Wide",9,user),
                new LinhKien(null,"Camera Ultra Wide",9,user),
                new LinhKien(null,"Camera Tele",9,user),
                new LinhKien(null,"Camera Bokeh",9,user),
                new LinhKien(null,"Front Camera",9,user),
                new LinhKien(null,"Camera Macro",9,user),
                new LinhKien(null,"Motor",16,user),
                new LinhKien(null,"Ant 5G",16,user),
                new LinhKien(null,"Power Key",16,user),
                new LinhKien(null,"Wifi",18,user),
                new LinhKien(null,"USB-C",18,user),
                new LinhKien(null,"GPS",18,user)
        );

        linhKienRepository.saveAll(linhKiens);
    }



}
