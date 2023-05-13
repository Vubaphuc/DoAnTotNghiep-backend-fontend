package com.example.doanbackend.config;

import com.example.doanbackend.exception.CustomAccessDeniedHandler;
import com.example.doanbackend.exception.CustomAuthenticationEntryPoint;
import com.example.doanbackend.security.CustomFilter;
import com.example.doanbackend.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.time.LocalDateTime;
import java.util.Random;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomFilter customFilter;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customUserDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        String [] PUBLIC = {
                "/login",
                "/nhan-vien/**"
        };

        String [] NHANVIENLETAN = {
                "/dang-ky/**",
                "/le-tan/san-pham/**",
                "/le-tan/**"
        };
        String [] NHANVIENSUACHUA = {
                "/nhan-vien-sua-chua/**"
        };
        String [] NHANVIENKHO = {
                "/nhan-vien-kho/**"
        };
        String [] NHANVIENBAOHANH = {
                ""
        };
        String [] QUANLY = {
                ""
        };
        String [] ADMIN = {
                ""
        };


        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(PUBLIC).permitAll()
                .requestMatchers(NHANVIENLETAN).hasRole("NHANVIENLETAN")
                .requestMatchers(NHANVIENSUACHUA).hasRole("NHANVIENSUACHUA")
                .requestMatchers(NHANVIENBAOHANH).hasRole("NHANVIENBAOHANH")
                .requestMatchers(NHANVIENKHO).hasRole("NHANVIENKHO")
                .requestMatchers(QUANLY).hasRole("QUANLY")
                .requestMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
