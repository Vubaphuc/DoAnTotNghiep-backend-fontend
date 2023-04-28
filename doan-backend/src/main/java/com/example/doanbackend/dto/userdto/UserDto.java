package com.example.doanbackend.dto.userdto;

import com.example.doanbackend.entity.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String fullName;
    private String email;
    private List<Role> roles;
}
