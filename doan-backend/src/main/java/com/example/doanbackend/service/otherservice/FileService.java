package com.example.doanbackend.service.otherservice;

import com.example.doanbackend.entity.Image;
import com.example.doanbackend.entity.User;
import com.example.doanbackend.exception.BadRequestException;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.ImageRepository;
import com.example.doanbackend.response.FileResponse;
import com.example.doanbackend.security.ICurrentUser;
import com.example.doanbackend.security.ICurrentUserLmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private ICurrentUserLmpl iCurrentUser;

    @Autowired
    private ImageService imageService;


    // uploadFile
    public FileResponse uploadFile(MultipartFile file) {

        // kiểm tra tiêu chuẩn file(kích thước file, type file, tên file)
        validataFile(file);

        try {
            User user = iCurrentUser.getUser();

            Image image = Image.builder()
                    .type(file.getContentType())
                    .data(file.getBytes())
                    .user(user)
                    .build();


            imageService.save(image);

            // đường dẫn. chỉnh sau. lưu đường dẫn vào thumbaiil
            FileResponse fileResponse = new FileResponse("http://localhost:8080/api/v1/admin/files/" + image.getId());

            return fileResponse;


        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    // đọc file, xem ảnh
    public Image readFile(Integer id) {
        Image image = imageService.findImageById(id);
        return image;
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
}
