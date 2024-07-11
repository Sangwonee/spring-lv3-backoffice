package com.sangwon.springlv3backoffice.instructor.dto;

import com.sangwon.springlv3backoffice.admin.entity.Admin;
import com.sangwon.springlv3backoffice.instructor.entity.Instructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorRegisterDto {
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotNull(message = "경력은 필수 입력 값입니다.")
    private Integer experienceYears;

    @NotBlank(message = "회사는 필수 입력 값입니다.")
    private String company;

    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    private String phone;

    private String introduction;
    public Instructor toEntity(Admin admin) {
        return new Instructor(name, experienceYears, company, phone, introduction, admin);
    }

}
