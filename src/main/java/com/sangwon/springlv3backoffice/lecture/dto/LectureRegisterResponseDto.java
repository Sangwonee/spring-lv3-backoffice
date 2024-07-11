package com.sangwon.springlv3backoffice.lecture.dto;

import com.sangwon.springlv3backoffice.lecture.entity.Lecture;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class LectureRegisterResponseDto {
    private Long id;
    private String title;
    private String price;
    private String description;
    private String category;
    private Long instructorId;
    private Long adminId;
    private String createdAt;

    public LectureRegisterResponseDto(Lecture lecture) {
        this.id = lecture.getId();
        this.title = lecture.getTitle();
        this.price = lecture.getPrice();
        this.description = lecture.getDescription();
        this.category = lecture.getCategory().name();
        this.instructorId = lecture.getInstructor().getId();
        this.adminId = lecture.getAdmin().getId();
        this.createdAt = lecture.getCreatedAt().toString();
    }
}
