package com.example.doanbackend.repository;

import com.example.doanbackend.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    Optional<Image> findImageById(Integer id);
}