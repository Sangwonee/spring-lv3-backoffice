package com.sangwon.springlv3backoffice.instructor.dto;

import com.sangwon.springlv3backoffice.instructor.entity.Instructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorRegisterResponseDto {
    private Long id;
    private String name;
    private Integer experienceYears;
    private String company;
    private String phone;
    private String introduction;
    private Long adminId;

    public InstructorRegisterResponseDto(Instructor instructor) {
        this.id = instructor.getId();
        this.name = instructor.getName();
        this.experienceYears = instructor.getExperienceYears();
        this.company = instructor.getCompany();
        this.phone = instructor.getPhone();
        this.introduction = instructor.getIntroduction();
        this.adminId = instructor.getAdmin().getId();
    }
}
