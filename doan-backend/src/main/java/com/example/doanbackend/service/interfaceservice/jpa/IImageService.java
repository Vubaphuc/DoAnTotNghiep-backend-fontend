package com.example.doanbackend.service.interfaceservice.jpa;

import com.example.doanbackend.entity.Image;

public interface IImageService {
    Image save(Image image);
    Image deleteById(Integer id);

    Image findImageById(Integer id);
}
