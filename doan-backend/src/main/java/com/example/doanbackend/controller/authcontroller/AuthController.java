package com.example.doanbackend.controller.authcontroller;

import com.example.doanbackend.entity.User;
import com.example.doanbackend.exception.NotFoundException;
import com.example.doanbackend.mapper.UserMapper;
import com.example.doanbackend.repository.UserRepository;
import com.example.doanbackend.request.LoginRequest;
import com.example.doanbackend.response.AuthResponse;
import com.example.doanbackend.security.JwtUtils;
import com.example.doanbackend.service.CustomUserDetailsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Tạo đối tượng xác thực
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );


        try {
            // Tiến hành xác thực
            Authentication authentication = authenticationManager.authenticate(token);

            // Lưu dữ liệu vào context
            SecurityContextHolder.getContext().setAuthentication(authentication);


            // Lấy ra thông tin của user
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(authentication.getName());

            // Tạo ra token
            String jwtToken = jwtUtils.generateToken(userDetails);

            // Tìm kiếm user
            User user = userRepository.findUsersByEmail(authentication.getName()).orElseThrow(() -> {
                throw new NotFoundException("Không tìm thấy tài khoản nào có gmail là " + authentication.getName());
            });


            return ResponseEntity.ok(new AuthResponse(
                   UserMapper.toUserDto(user),
                    jwtToken,
                    true
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
