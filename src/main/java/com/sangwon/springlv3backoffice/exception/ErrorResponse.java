package com.sangwon.springlv3backoffice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private final int status;
    private final String message;

    public ErrorResponse(ExceptionCode exceptionCode) {
        this.status = exceptionCode.getHttpStatus().value();
        this.message = exceptionCode.getMessage();
    }
}
