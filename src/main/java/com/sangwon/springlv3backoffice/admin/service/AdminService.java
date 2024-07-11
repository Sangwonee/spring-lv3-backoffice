package com.sangwon.springlv3backoffice.admin.service;

import com.sangwon.springlv3backoffice.admin.dto.AdminRegisterDto;
import com.sangwon.springlv3backoffice.admin.dto.AdminRegisterResponseDto;
import com.sangwon.springlv3backoffice.admin.entity.Admin;
import com.sangwon.springlv3backoffice.admin.enums.Department;
import com.sangwon.springlv3backoffice.admin.enums.Role;
import com.sangwon.springlv3backoffice.admin.mapper.AdminMapper;
import com.sangwon.springlv3backoffice.admin.repository.AdminRepository;
import com.sangwon.springlv3backoffice.exception.BusinessLogicException;
import com.sangwon.springlv3backoffice.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;

    // 관리자 가입
    public AdminRegisterResponseDto registerAdmin(AdminRegisterDto adminRegisterDto){
        if(adminRepository.findByEmail(adminRegisterDto.getEmail()).isPresent()){
            throw new BusinessLogicException(ExceptionCode.EMAIL_ALREADY_EXISTS);
        }
        // 부서와 권한 확인 로직 추가
        if (adminRegisterDto.getRole() == Role.MANAGER &&
                (adminRegisterDto.getDepartment() != Department.DEVELOPMENT &&
                        adminRegisterDto.getDepartment() != Department.CURRICULUM)) {
            throw new BusinessLogicException(ExceptionCode.INVALID_ROLE_FOR_DEPARTMENT);
        }
        Admin admin = adminMapper.toEntity(adminRegisterDto);

        admin.encodePassword(passwordEncoder);

        Admin savedAdmin = adminRepository.save(admin);
        return adminMapper.toAdminRegisterResponseDto(savedAdmin);
    }

}
