package com.sangwon.springlv3backoffice.admin.dto;

import com.sangwon.springlv3backoffice.admin.enums.Department;
import com.sangwon.springlv3backoffice.admin.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRegisterResponseDto {
    private Long id;
    private String email;
    private Department department;
    private Role role;
}
