package com.sangwon.springlv3backoffice.admin.controller;

import com.sangwon.springlv3backoffice.admin.dto.AdminRegisterDto;
import com.sangwon.springlv3backoffice.admin.dto.AdminRegisterResponseDto;
import com.sangwon.springlv3backoffice.admin.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;
    @PostMapping
    public ResponseEntity<AdminRegisterResponseDto> registerAdmin(@Valid @RequestBody AdminRegisterDto adminRegisterDto){
        AdminRegisterResponseDto adminRegisterResponseDto = adminService.registerAdmin(adminRegisterDto);
        return new ResponseEntity<>(adminRegisterResponseDto, HttpStatus.CREATED);
    }
}
