package com.example.doanbackend.controller;

import com.example.doanbackend.entity.Account;
import com.example.doanbackend.entity.request.LoginRequest;
import com.example.doanbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("login")
    public ResponseEntity<?> login (@RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginService.login(request));
    }
}
