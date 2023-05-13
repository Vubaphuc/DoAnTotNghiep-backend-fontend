package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.entity.Image;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.ImageRepository;
import com.example.doanbackend.service.interfaceservice.jpa.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityImageService implements IImageService {

    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Image save(Image image) {
        imageRepository.save(image);
        return image;
    }

    @Override
    public Image deleteById(Integer id) {
        Image image = imageRepository.findImageById(id).orElseThrow(() -> {
            throw new NotFoundException("Không Tìm thấy Image với id = " + id);
        });

        imageRepository.deleteById(image.getId());
        return image;
    }

    @Override
    public Image findImageById(Integer id) {
        Image image = imageRepository.findImageById(id).orElseThrow(() -> {
            throw new NotFoundException("Không Tìm thấy Image với id = " + id);
        });
        return image;
    }
}
