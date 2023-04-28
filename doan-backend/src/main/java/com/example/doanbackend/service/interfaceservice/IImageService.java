package com.example.doanbackend.service.interfaceservice;

import com.example.doanbackend.entity.Image;

public interface IImageService {
    Image save(Image image);
    Image updateById(Integer id);
    Image deleteById(Integer id);

    Image findImageById(Integer id);
}
