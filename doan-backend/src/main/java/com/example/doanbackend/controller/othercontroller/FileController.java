package com.example.doanbackend.controller.othercontroller;


import com.example.doanbackend.entity.Image;
import com.example.doanbackend.response.FileResponse;
import com.example.doanbackend.service.otherservice.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("files")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> uploadFile(@ModelAttribute("file")MultipartFile file) {
        FileResponse fileResponse = fileService.uploadFile(file);
        return ResponseEntity.ok(fileResponse);
    }

    // xem anh
    @GetMapping("files/{id}")
    public ResponseEntity<?>  findFileById(@PathVariable Integer id) {
        Image image = fileService.readFile(id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(image.getType()))
                .body(image.getData());
    }
}
