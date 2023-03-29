package com.example.doanbackend.service;

import com.example.doanbackend.entity.Account;
import com.example.doanbackend.entity.request.LoginRequest;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AccountRepository accountRepository;

    public Account login(LoginRequest request) {
        Account account = accountRepository.findAccountByUserName(request.getUserName())
                .stream()
                .filter(acc -> acc.getPassword().equals(request.getPasswork()))
                .findFirst()
                .orElseThrow(() -> {
            throw new NotFoundException("UserName hoặc password không đúng");
        });

        return account;
    }
}
