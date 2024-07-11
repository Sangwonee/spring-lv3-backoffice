package com.sangwon.springlv3backoffice.lecture.dto;

import com.sangwon.springlv3backoffice.admin.entity.Admin;
import com.sangwon.springlv3backoffice.instructor.entity.Instructor;
import com.sangwon.springlv3backoffice.lecture.entity.Lecture;
import com.sangwon.springlv3backoffice.lecture.enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureRegisterDto {
    private String title;
    private String price;
    private String description;
    private Category category;
    private Long instructorId;


    public Lecture toEntity(Instructor instructor, Admin admin) {
        return new Lecture(title, price, description, category, instructor, admin);
    }
}
