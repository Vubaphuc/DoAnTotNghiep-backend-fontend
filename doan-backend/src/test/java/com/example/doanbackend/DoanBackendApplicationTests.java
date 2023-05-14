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
    private LoaiNhanVienRepository loaiNhanVienRepository;
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
                new Role(null, "QUANLY"),
                new Role(null, "ADMIN")
        );

        roleRepository.saveAll(roles);
    }

    @Test
    void save_loaiNhanVien() {
        List<LoaiNhanVien> loaiNhanViens = List.of(
                new LoaiNhanVien(null, "Nhân Viên Lễ Tân"),
                new LoaiNhanVien(null, "Nhân Viên Kho"),
                new LoaiNhanVien(null, "Nhân Viên Sửa Chữa"),
                new LoaiNhanVien(null, "Nhân Viên Bảo Hành"),
                new LoaiNhanVien(null, "Quản Lý")
        );

        loaiNhanVienRepository.saveAll(loaiNhanViens);
    }

    @Test
    void save_vendor() {
        List<Vendor> vendors = List.of(
                new Vendor(null,"QUALCOMM"),
                new Vendor(null,"MEDIAMART"),
                new Vendor(null,"SHANNON"),
                new Vendor(null,"SAMSUNG")
        );

        vendorRepository.saveAll(vendors);

    }

    @Test
    void save_users () {

        Role khoRole = roleRepository.findRoleByName("NHANVIENKHO").orElse(null);
        Role baoHanhRole = roleRepository.findRoleByName("NHANVIENBAOHANH").orElse(null);
        Role suaChuaRole = roleRepository.findRoleByName("NHANVIENSUACHUA").orElse(null);
        Role leTanRole = roleRepository.findRoleByName("NHANVIENLETAN").orElse(null);
        Role quanLyRole = roleRepository.findRoleByName("QUANLY").orElse(null);
        Role ADMINRole = roleRepository.findRoleByName("ADMIN").orElse(null);

        LoaiNhanVien nhanVienKho = loaiNhanVienRepository.findByName("Nhân Viên Kho").orElse(null);
        LoaiNhanVien nhanvienbaohanh = loaiNhanVienRepository.findByName("Nhân Viên Bảo Hành").orElse(null);
        LoaiNhanVien nhanVienSuaChua = loaiNhanVienRepository.findByName("Nhân Viên Sửa Chữa").orElse(null);
        LoaiNhanVien nhanVienLeTan = loaiNhanVienRepository.findByName("Nhân Viên Lễ Tân").orElse(null);
        LoaiNhanVien quanLy = loaiNhanVienRepository.findByName("Quản lý").orElse(null);

        List<User> users = List.of(
                new User(null, generateCode.generateCode(),"Diệu Linh", "linh@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(khoRole),nhanVienKho),
                new User(null, generateCode.generateCode(),"Bá Hậu", "hau@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(baoHanhRole),nhanvienbaohanh),
                new User(null, generateCode.generateCode(),"Bá Phúc", "phuc@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(ADMINRole),null),
                new User(null, generateCode.generateCode(),"Giáp Nhàn", "nhan@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(leTanRole),nhanVienLeTan),
                new User(null, generateCode.generateCode(),"Đăng Quang", "quang@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(suaChuaRole),nhanVienSuaChua),
                new User(null, generateCode.generateCode(),"Phùng Văn Tài", "tai@gmail.com",passwordEncoder.encode("111"),"0968616076","Hà Nội",null,List.of(suaChuaRole),nhanVienSuaChua)
        );

        userRepository.saveAll(users);

    }

    @Test
    void save_linhKien () {
        List<LinhKien> linhKiens = List.of(
                new LinhKien(null,"LCD",12,null),
                new LinhKien(null,"BackGlass",12,null),
                new LinhKien(null,"Rear",12,null),
                new LinhKien(null,"PIN",12,null),
                new LinhKien(null,"FRONT",12,null),
                new LinhKien(null,"PBA",12,null),
                new LinhKien(null,"Sub PBA",12,null),
                new LinhKien(null,"SPK",12,null),
                new LinhKien(null,"Camera Wide",9,null),
                new LinhKien(null,"Camera Ultra Wide",9,null),
                new LinhKien(null,"Camera Tele",9,null),
                new LinhKien(null,"Camera Bokeh",9,null),
                new LinhKien(null,"Front Camera",9,null),
                new LinhKien(null,"Camera Macro",9,null),
                new LinhKien(null,"Motor",16,null),
                new LinhKien(null,"Ant 5G",16,null),
                new LinhKien(null,"Power Key",16,null),
                new LinhKien(null,"Wifi",18,null),
                new LinhKien(null,"USB-C",18,null),
                new LinhKien(null,"GPS",18,null)
        );

        linhKienRepository.saveAll(linhKiens);
    }

    @Test
    void save_vatLieu () {

        List<Vendor> vendors = vendorRepository.findAll();
        List<LinhKien> linhKiens = linhKienRepository.findAll();

        List<VatLieu> vatLieus = List.of(
                new VatLieu(null, generateCode.generateCode(), "G781B/128D",50,null,null,vendors,linhKiens.get(0)),
                new VatLieu(null, generateCode.generateCode(), "N770F/128D",50,null,null,vendors,linhKiens.get(0)),
                new VatLieu(null, generateCode.generateCode(), "G990F/128D",50,null,null,vendors,linhKiens.get(0)),
                new VatLieu(null, generateCode.generateCode(), "F926B/128D",50,null,null,vendors,linhKiens.get(1)),
                new VatLieu(null, generateCode.generateCode(), "F926B/128D",50,null,null,vendors,linhKiens.get(1)),
                new VatLieu(null, generateCode.generateCode(), "N770F/128D",50,null,null,vendors,linhKiens.get(1)),
                new VatLieu(null, generateCode.generateCode(), "F926B/128D",50,null,null,vendors,linhKiens.get(1)),
                new VatLieu(null, generateCode.generateCode(), "F926B/128D",50,null,null,vendors,linhKiens.get(2)),
                new VatLieu(null, generateCode.generateCode(), "G781B/128D",50,null,null,vendors,linhKiens.get(2)),
                new VatLieu(null, generateCode.generateCode(), "F926B/128D",50,null,null,vendors,linhKiens.get(2)),
                new VatLieu(null, generateCode.generateCode(), "N920F/128D",50,null,null,vendors,linhKiens.get(2)),
                new VatLieu(null, generateCode.generateCode(), "A325F/128D",50,null,null,vendors,linhKiens.get(3)),
                new VatLieu(null, generateCode.generateCode(), "IPhone 14",50,null,null,vendors,linhKiens.get(3)),
                new VatLieu(null, generateCode.generateCode(), "Xiaomi 1",50,null,null,vendors,linhKiens.get(3)),
                new VatLieu(null, generateCode.generateCode(), "N920F/128D",50,null,null,vendors,linhKiens.get(3)),
                new VatLieu(null, generateCode.generateCode(), "G781B/128D",50,null,null,vendors,linhKiens.get(4)),
                new VatLieu(null, generateCode.generateCode(), "F926B/128D",50,null,null,vendors,linhKiens.get(4)),
                new VatLieu(null, generateCode.generateCode(), "N920F/128D",50,null,null,vendors,linhKiens.get(4)),
                new VatLieu(null, generateCode.generateCode(), "F936B/128D",50,null,null,vendors,linhKiens.get(5)),
                new VatLieu(null, generateCode.generateCode(), "N920F/128D",50,null,null,vendors,linhKiens.get(5)),
                new VatLieu(null, generateCode.generateCode(), "F926B/128D",50,null,null,vendors,linhKiens.get(5)),
                new VatLieu(null, generateCode.generateCode(), "F926B/128D",50,null,null,vendors,linhKiens.get(6)),
                new VatLieu(null, generateCode.generateCode(), "N920F/128D",50,null,null,vendors,linhKiens.get(6)),
                new VatLieu(null, generateCode.generateCode(), "W2022B/128D",50,null,null,vendors,linhKiens.get(6)),
                new VatLieu(null, generateCode.generateCode(), "A325F/128D",50,null,null,vendors,linhKiens.get(7)),
                new VatLieu(null, generateCode.generateCode(), "N920F/128D",50,null,null,vendors,linhKiens.get(7)),
                new VatLieu(null, generateCode.generateCode(), "A326B/128D",50,null,null,vendors,linhKiens.get(7)),
                new VatLieu(null, generateCode.generateCode(), "A325F/128D",50,null,null,vendors,linhKiens.get(8)),
                new VatLieu(null, generateCode.generateCode(), "A325F/128D",50,null,null,vendors,linhKiens.get(8)),
                new VatLieu(null, generateCode.generateCode(), "A325F/128D",50,null,null,vendors,linhKiens.get(8)),
                new VatLieu(null, generateCode.generateCode(), "A325F/128D",50,null,null,vendors,linhKiens.get(9)),
                new VatLieu(null, generateCode.generateCode(), "A326B/128D",50,null,null,vendors,linhKiens.get(9)),
                new VatLieu(null, generateCode.generateCode(), "N920F/128D",50,null,null,vendors,linhKiens.get(9)),
                new VatLieu(null, generateCode.generateCode(), "F936B/128D",50,null,null,vendors,linhKiens.get(10)),
                new VatLieu(null, generateCode.generateCode(), "A326B/128D",50,null,null,vendors,linhKiens.get(10)),
                new VatLieu(null, generateCode.generateCode(), "A536B/128D",50,null,null,vendors,linhKiens.get(10)),
                new VatLieu(null, generateCode.generateCode(), "A536B/128D",50,null,null,vendors,linhKiens.get(11)),
                new VatLieu(null, generateCode.generateCode(), "A325F/128D",50,null,null,vendors,linhKiens.get(11)),
                new VatLieu(null, generateCode.generateCode(), "IPhone 11",50,null,null,vendors,linhKiens.get(11)),
                new VatLieu(null, generateCode.generateCode(), "A536B/128D",50,null,null,vendors,linhKiens.get(12)),
                new VatLieu(null, generateCode.generateCode(), "Ịhone 12",50,null,null,vendors,linhKiens.get(12)),
                new VatLieu(null, generateCode.generateCode(), "N920F/128D",50,null,null,vendors,linhKiens.get(12)),
                new VatLieu(null, generateCode.generateCode(), "N920F/128D",50,null,null,vendors,linhKiens.get(13)),
                new VatLieu(null, generateCode.generateCode(), "Iphone 13",50,null,null,vendors,linhKiens.get(13)),
                new VatLieu(null, generateCode.generateCode(), "A325F/128D",50,null,null,vendors,linhKiens.get(13)),
                new VatLieu(null, generateCode.generateCode(), "Xiaomi 1",50,null,null,vendors,linhKiens.get(14)),
                new VatLieu(null, generateCode.generateCode(), "Iphone 14",50,null,null,vendors,linhKiens.get(14)),
                new VatLieu(null, generateCode.generateCode(), "A326B/128D",50,null,null,vendors,linhKiens.get(14)),
                new VatLieu(null, generateCode.generateCode(), "A536B/128D",50,null,null,vendors,linhKiens.get(15)),
                new VatLieu(null, generateCode.generateCode(), "Xiaomi 1",50,null,null,vendors,linhKiens.get(15)),
                new VatLieu(null, generateCode.generateCode(), "Iphone 13",50,null,null,vendors,linhKiens.get(15)),
                new VatLieu(null, generateCode.generateCode(), "Xiaomi 2",50,null,null,vendors,linhKiens.get(16)),
                new VatLieu(null, generateCode.generateCode(), "A536B/128D",50,null,null,vendors,linhKiens.get(16)),
                new VatLieu(null, generateCode.generateCode(), "IPhone 12",50,null,null,vendors,linhKiens.get(16)),
                new VatLieu(null, generateCode.generateCode(), "A536B/128D",50,null,null,vendors,linhKiens.get(17)),
                new VatLieu(null, generateCode.generateCode(), "F936B/128D",50,null,null,vendors,linhKiens.get(17)),
                new VatLieu(null, generateCode.generateCode(), "Oppo A50",50,null,null,vendors,linhKiens.get(17)),
                new VatLieu(null, generateCode.generateCode(), "Iphone 12",50,null,null,vendors,linhKiens.get(18)),
                new VatLieu(null, generateCode.generateCode(), "A325F/128D",50,null,null,vendors,linhKiens.get(18)),
                new VatLieu(null, generateCode.generateCode(), "Oppo A54",50,null,null,vendors,linhKiens.get(18)),
                new VatLieu(null, generateCode.generateCode(), "Xiaomi 2",50,null,null,vendors,linhKiens.get(19)),
                new VatLieu(null, generateCode.generateCode(), "Huawei 1",50,null,null,vendors,linhKiens.get(19)),
                new VatLieu(null, generateCode.generateCode(), "Oppo A54",50,null,null,vendors,linhKiens.get(19))

        );
        vatLieuRepository.saveAll(vatLieus);
    }

    @Test
    void save_khachHang () {
        // id , mã khách hàng, fullname, số điện thoại, email, địa chỉ , null
        KhachHang khachHang1 = new KhachHang(null, generateCode.generateCode(), "Trần Thị Huyền","0976111111","huyen@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang2 = new KhachHang(null, generateCode.generateCode(), "Hà Văn Giang","0976111112","giang@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang3 = new KhachHang(null, generateCode.generateCode(), "Đỗ Văn Nhị","0976111113","nhi@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang4 = new KhachHang(null, generateCode.generateCode(), "Nguyễn Văn Luân","0976111114","luan@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang5 = new KhachHang(null, generateCode.generateCode(), "Nguyễn Văn Nam","0976111115","nam@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang6 = new KhachHang(null, generateCode.generateCode(), "Trần Thị Thương","0976111116","thuong@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang7 = new KhachHang(null, generateCode.generateCode(), "Nguyễn Thị Loan","0976111117","loan@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang8 = new KhachHang(null, generateCode.generateCode(), "Ngô Văn Hiếu","0976111118","hieu@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang9 = new KhachHang(null, generateCode.generateCode(), "Đỗ Văn Đức","0976111119","duc@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang10 = new KhachHang(null, generateCode.generateCode(), "Nguyễn Như Kiên","0976111110","kien@gmail.com","Thành Phố Hà Nội",null);
        KhachHang khachHang11 = new KhachHang(null, generateCode.generateCode(), "Vũ Thị Tâm","0976111121","tam@gmail.com","Thành Phố Hà Nội",null);

        khachHangRepository.save(khachHang1);
        khachHangRepository.save(khachHang2);
        khachHangRepository.save(khachHang3);
        khachHangRepository.save(khachHang4);
        khachHangRepository.save(khachHang5);
        khachHangRepository.save(khachHang6);
        khachHangRepository.save(khachHang7);
        khachHangRepository.save(khachHang8);
        khachHangRepository.save(khachHang9);
        khachHangRepository.save(khachHang10);
        khachHangRepository.save(khachHang11);

        User nhanVienLeTan = userRepository.findById(4).orElse(null);
        User nhanVienKho = userRepository.findById(1).orElse(null);
        User nhanVienSuaChua1 = userRepository.findById(5).orElse(null);
        User nhanVienSuaChua2 = userRepository.findById(6).orElse(null);

        ThongTinLeTan thongTinLeTan1 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);
        ThongTinLeTan thongTinLeTan2 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);
        ThongTinLeTan thongTinLeTan3 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);
        ThongTinLeTan thongTinLeTan4 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);

        ThongTinLeTan thongTinLeTan5 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);
        ThongTinLeTan thongTinLeTan6 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);
        ThongTinLeTan thongTinLeTan7 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);
        ThongTinLeTan thongTinLeTan8 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);
        ThongTinLeTan thongTinLeTan9 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);
        ThongTinLeTan thongTinLeTan10 = new ThongTinLeTan(null,null,null,null,nhanVienLeTan);

        thongTinLeTanRepository.save(thongTinLeTan1);
        thongTinLeTanRepository.save(thongTinLeTan2);
        thongTinLeTanRepository.save(thongTinLeTan3);
        thongTinLeTanRepository.save(thongTinLeTan4);
        thongTinLeTanRepository.save(thongTinLeTan5);
        thongTinLeTanRepository.save(thongTinLeTan6);
        thongTinLeTanRepository.save(thongTinLeTan7);
        thongTinLeTanRepository.save(thongTinLeTan8);
        thongTinLeTanRepository.save(thongTinLeTan9);
        thongTinLeTanRepository.save(thongTinLeTan10);

        LinhKien linhKien1 = linhKienRepository.findById(1).orElse(null);
        LinhKien linhKien2 = linhKienRepository.findById(8).orElse(null);
        LinhKien linhKien3 = linhKienRepository.findById(11).orElse(null);
        LinhKien linhKien4 = linhKienRepository.findById(13).orElse(null);

        // null, nguyên nhân lỗi, null, vị trí sửa, chú thích, nhân viên sửa.
        ThongTinSuaChua thongTinSuaChua1 = new ThongTinSuaChua(null,"Tối LCD", null, "LCD",null,nhanVienSuaChua1,linhKien1 );
        ThongTinSuaChua thongTinSuaChua2 = new ThongTinSuaChua(null,"Không ÂM Loa Ngoài", null, "SPK",null,nhanVienSuaChua1,linhKien2 );
        ThongTinSuaChua thongTinSuaChua3 = new ThongTinSuaChua(null,"Không vào được camera sau", null, "Camera Tele",null,nhanVienSuaChua2,linhKien3 );
        ThongTinSuaChua thongTinSuaChua4 = new ThongTinSuaChua(null,"Không vào được camera trước", null, "Front Camera",null,nhanVienSuaChua2,linhKien4 );

        thongTinSuaChuaRepository.save(thongTinSuaChua1);
        thongTinSuaChuaRepository.save(thongTinSuaChua2);
        thongTinSuaChuaRepository.save(thongTinSuaChua3);
        thongTinSuaChuaRepository.save(thongTinSuaChua4);
        // id, model, hãng sản xuât, ime, tên lỗi, trang thái , số lượng, giá tiền, thành tiền, hóa đơn, khách hàng, thông tin sửa chữa, thông tin lễ tân


        SanPham sanPham1 = new SanPham(null,"N920F/128D","SAMSUNG", "123456789","Tối LCD", null,1,2000000,2000000,null,khachHang1,thongTinSuaChua1,thongTinLeTan1);
        SanPham sanPham2 = new SanPham(null,"F936B/128D","SAMSUNG", "123456789","Không ÂM Loa Ngoài", null,1,2000000,2000000,null,khachHang2,thongTinSuaChua2,thongTinLeTan2);
        SanPham sanPham3 = new SanPham(null,"IPhone 14","APPLE", "123456789","Không vào được camera sau", null,1,2000000,2000000,null,khachHang3,thongTinSuaChua3,thongTinLeTan3);
        SanPham sanPham4 = new SanPham(null,"Oppo A54","OPPO", "123456789","Không vào được camera trước", null,1,2000000,2000000,null,khachHang4,thongTinSuaChua4,thongTinLeTan4);

        SanPham sanPham5 = new SanPham(null,"A536B/128D","SAMSUNG", "123456789","Tối LCD", null,1,2000000,2000000,null,khachHang5,null,thongTinLeTan5);
        SanPham sanPham6 = new SanPham(null,"Xiaomi 2","XIAOMI", "123456789","Tối LCD", null,1,2000000,2000000,null,khachHang6,null,thongTinLeTan6);
        SanPham sanPham7 = new SanPham(null,"Oppo A50","OPPO", "123456789","Tối LCD", null,1,2000000,2000000,null,khachHang7,null,thongTinLeTan7);
        SanPham sanPham8 = new SanPham(null,"Ịhone 12","APPLE", "123456789","Tối LCD", null,1,2000000,2000000,null,khachHang8,null,thongTinLeTan8);
        SanPham sanPham9 = new SanPham(null,"F936B/128D","SAMSUNG", "123456789","Tối LCD", null,1,2000000,2000000,null,khachHang9,null,thongTinLeTan9);
        SanPham sanPham10 = new SanPham(null,"N920F/128D","SAMSUNG", "123456789","Tối LCD", null,1,2000000,2000000,null,khachHang10,null,thongTinLeTan10);

        sanPhamRepository.save(sanPham1);
        sanPhamRepository.save(sanPham2);
        sanPhamRepository.save(sanPham3);
        sanPhamRepository.save(sanPham4);
        sanPhamRepository.save(sanPham5);
        sanPhamRepository.save(sanPham6);
        sanPhamRepository.save(sanPham7);
        sanPhamRepository.save(sanPham8);
        sanPhamRepository.save(sanPham9);
        sanPhamRepository.save(sanPham10);


        sanPham1.setTrangThai("OK");
        sanPham2.setTrangThai("OK");
        sanPham3.setTrangThai("OK");
        sanPham4.setTrangThai("OK");

        sanPhamRepository.save(sanPham1);
        sanPhamRepository.save(sanPham2);
        sanPhamRepository.save(sanPham3);
        sanPhamRepository.save(sanPham4);


    }

}
