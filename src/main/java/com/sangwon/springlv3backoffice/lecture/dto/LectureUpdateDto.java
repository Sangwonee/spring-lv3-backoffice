package com.sangwon.springlv3backoffice.lecture.dto;

import com.sangwon.springlv3backoffice.lecture.enums.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureUpdateDto {
    private String title;
    private String price;
    private String description;
    private Category category;
}
