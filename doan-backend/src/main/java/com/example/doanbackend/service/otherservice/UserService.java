package com.example.doanbackend.service.otherservice;

import com.example.doanbackend.entity.User;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.UserRepository;
import com.example.doanbackend.service.interfaceservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateById(Integer id) {
        User user = userRepository.findUsersById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy User có id = " + id);
        });
        userRepository.save(user);
        return user;
    }

    @Override
    public User deleteById(Integer id) {
        User user = userRepository.findUsersById(id).orElseThrow(() -> {
            throw new NotFoundException("Không tìm thấy User có id = " + id);
        });

        userRepository.deleteById(user.getId());
        return user;
    }
}
