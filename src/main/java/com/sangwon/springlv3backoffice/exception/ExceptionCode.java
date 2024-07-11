package com.sangwon.springlv3backoffice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public enum ExceptionCode {
    ADMIN_NOT_FOUND(HttpStatus.BAD_REQUEST,"관리자를 찾을 수 없습니다."),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "이메일이 이미 존재합니다."),
    INVALID_ROLE_FOR_DEPARTMENT(HttpStatus.BAD_REQUEST,"커리큘럼, 개발 부서만 MANAGER 권한을 부여 받을 수 있습니다."),
    INSTRUCTOR_NOT_FOUND(HttpStatus.NOT_FOUND, "강사를 찾을 수 없습니다."),
    LECTURE_NOT_FOUND(HttpStatus.NOT_FOUND, "강의를 찾을 수 없습니다.");;


    private final HttpStatus httpStatus;
    private final String message;

    ExceptionCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
