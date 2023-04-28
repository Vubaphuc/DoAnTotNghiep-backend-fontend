package com.example.doanbackend.security;

import com.example.doanbackend.entity.User;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ICurrentUserLmpl implements ICurrentUser{

    private final UserRepository userRepository;
    @Override
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findUsersByEmail(authentication.getName()).orElseThrow(() -> {
            throw new NotFoundException("Not found user");
        });
    }
}
