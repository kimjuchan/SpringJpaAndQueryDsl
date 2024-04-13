package com.example.dev_jpa.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ApiSuccessCode {

    OK(HttpStatus.OK, "정상 처리 완료."),
    CREATED(HttpStatus.CREATED, "등록 완료."),
    UPDATE(HttpStatus.OK, "수정 완료."),
    NO_CONTENT(HttpStatus.NO_CONTENT, "등록 완료 > 해당 컨텐츠 정보 없음.");

    private HttpStatus httpStatus;
    private String message;

    public String toString() {
        return "[" + this.httpStatus.value() + "] :: " + this.name();
    }
}
