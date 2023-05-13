package com.example.doanbackend.service.jpaservice;

import com.example.doanbackend.dto.LinhKienDto;
import com.example.doanbackend.entity.LinhKien;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.LinhKienRepository;
import com.example.doanbackend.service.interfaceservice.jpa.ILinhKienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityLinhKienService implements ILinhKienService {
    @Autowired
    private LinhKienRepository linhKienRepository;
    @Override
    public void save(LinhKien linhKien) {
        linhKienRepository.save(linhKien);
    }

    @Override
    public LinhKien findById(Integer id) {
        return linhKienRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy linh kiện nào có id là " + id);
        });
    }

    @Override
    public LinhKien findByName(String name) {
        return linhKienRepository.findByName(name).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy linh kiện có tên là " + name);
        });
    }

    @Override
    public Page<LinhKienDto> danhSachLinhKien(int page, int pageSize) {
        return linhKienRepository.layDanhSachLinhKienCoPhanTrang(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Optional<LinhKien> kiemTraTenLinhKien (String name) {
        return linhKienRepository.findByName(name);
    }
}
