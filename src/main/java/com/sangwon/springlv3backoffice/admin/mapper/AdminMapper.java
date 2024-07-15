package com.sangwon.springlv3backoffice.admin.mapper;


import com.sangwon.springlv3backoffice.admin.dto.AdminRegisterDto;
import com.sangwon.springlv3backoffice.admin.dto.AdminRegisterResponseDto;
import com.sangwon.springlv3backoffice.admin.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    Admin toEntity(AdminRegisterDto adminRegisterDto);
    AdminRegisterResponseDto toAdminRegisterResponseDto(Admin admin);

}
