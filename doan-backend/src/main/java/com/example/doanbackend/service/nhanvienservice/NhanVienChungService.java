package com.example.doanbackend.service.nhanvienservice;


import com.example.doanbackend.dto.userdto.UserDto;
import com.example.doanbackend.entity.Image;
import com.example.doanbackend.entity.User;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.mapper.UserMapper;
import com.example.doanbackend.request.CapNhatThongTinCaNhan;
import com.example.doanbackend.request.DoiMatKhau;
import com.example.doanbackend.request.QuenMatKhau;
import com.example.doanbackend.response.FileResponse;
import com.example.doanbackend.security.ICurrentUserLmpl;
import com.example.doanbackend.service.jpaservice.EntityFileService;
import com.example.doanbackend.service.jpaservice.EntityUserService;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


@Service
public class NhanVienChungService {

    @Autowired
    private ICurrentUserLmpl iCurrentUserLmpl;
    @Autowired
    private EntityUserService entityUserService;

    @Autowired
    private EmailService emailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EntityFileService entityFileService;




    // quên mật khẩu
    public String quenMatKhau(QuenMatKhau quenMatKhau) {
        // lấy User theo Email;
        User user = entityUserService.timKiemUserBangEmail(quenMatKhau.getEmail());
        // tạo mật khẩu mới ngẫu nhiên
        Random rd = new Random();
        String newPassword = String.valueOf(rd.nextInt(900) + 100);
        // set lại mật khẩu cho user
        user.setPassword(passwordEncoder.encode(newPassword));
        // lưu user mới thay đổi mật khẩu vào csdl
        entityUserService.save(user);


//        emailService.guiMail(user.getEmail(),"New Password","Mật khẩu mới của bạn là " + newPassword);

        return newPassword;
    }

    public String doiMatKhau(DoiMatKhau doiMatKhau) {

        User user = iCurrentUserLmpl.getUser();

        if (!passwordEncoder.matches(doiMatKhau.getOldPassword(), user.getPassword())) {
            throw new BadRequestException("Mật khẩu cũ không đúng");
        }

        if (doiMatKhau.getOldPassword().equals(doiMatKhau.getNewPassword1())) {
            throw new BadRequestException("Mật khẩu mới không được trùng với mật khẩu cũ");
        }

        if (!doiMatKhau.getNewPassword1().equals(doiMatKhau.getNewPassword2())) {
            throw new BadRequestException("Mật khẩu mới không trùng khớp");
        }

        user.setPassword(passwordEncoder.encode(doiMatKhau.getNewPassword1()));

        entityUserService.save(user);

        return "Đổi mật khẩu thành công";

    }

    // Cập nhât thông thông tin cá nhân
    public UserDto capNhatThongTinCaNhan(CapNhatThongTinCaNhan capNhatThongTinCaNhan) {

        User user = iCurrentUserLmpl.getUser();

        user.setFullName(capNhatThongTinCaNhan.getFullName());
        user.setPhoneNumber(capNhatThongTinCaNhan.getPhone());
        user.setAddress(capNhatThongTinCaNhan.getAddress());

        entityUserService.save(user);

        return UserMapper.toUserDto(user);

    }


    // cập nhật ảnh đại diện
    public String capNhatAnhDaiDien(MultipartFile avatar) {
        // kiểm tra tiêu chuẩn file(kích thước file, type file, tên file)
        validataFile(avatar);

        try {
            User user = iCurrentUserLmpl.getUser();

            Image image = Image.builder()
                    .type(avatar.getContentType())
                    .data(avatar.getBytes())
                    .user(user)
                    .build();


            entityFileService.save(image);

            user.setAvatar(image);

            entityUserService.save(user);


            return "Cập nhật thành công";


        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    // kiểm tra file xem có đúng yêu cầu và các thông số không
    private void validataFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();

        // kiểm tra tên file có trống không
        if (fileName == null || fileName.isEmpty()) {
            // nếu trống thì trả về lỗi
            throw new BadRequestException("Tên file không hợp lệ");
        }



        // avatar.png, image.jpg => lấy ra đuôi file png và jpg
        // lấy ra đuôi ffile
        String fileExtension = getFileExtension(fileName);

        // kiểm tra type (loại) file có nằm trong danh sánh cho phép hay không
        if (!checkFileExtension(fileExtension)) {
            // nếu đuôi file không hợp lệ thì trả về lỗi
            throw new BadRequestException("Type File không hợp lệ");
        }

        // kiểm tra kích thước file có trong phạm vi cho phép upload không
        // 1048576 = 1MB
        double fileSize = (double) file.getSize() / 1048576;
        // kiểm tra dung lượng file có lớn hơn 2MB không
        if (fileSize > 2) {
            throw new BadRequestException("Size File không được vượt quá 2MB");
        }
    }


    // lấy ra đuôi ffile
    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex == -1) {
            return "";
        }
        return fileName.substring(lastIndex + 1);
    }

    // kiểm tra đuôi file có theo yêu cầu không. có thì trả về true không trả về false
    private boolean checkFileExtension (String fileExtension) {
        List<String> fileExtensions = List.of("png","jpeg","jpg");
        return fileExtensions.contains(fileExtension);

    }

    // lấy ảnh đại diện user theo id
    public Image layAnhdaiDienTheoId(Integer id) {

        if (iCurrentUserLmpl.getUser().getId() != id) {
            throw new BadRequestException("ID: " + id + " không phải ID của bạn");
        }

        if (iCurrentUserLmpl.getUser().getAvatar() == null) {
                try {
                    Path path = Paths.get("src/main/resources/static/images/avatar-mac-dinh.png");
                    byte[] defaultImageData = Files.readAllBytes(path);

                    Image image = Image.builder()
                            .type("avatar-mac-dinh/png")
                            .data(defaultImageData)
                            .build();
                    return image;

                } catch (IOException e) {
                    throw new NotFoundException("Không thể truy cập avatar");
                }
            }

        Image image = entityFileService.findImageById(iCurrentUserLmpl.getUser().getAvatar().getId());


        return image;

    }
}
