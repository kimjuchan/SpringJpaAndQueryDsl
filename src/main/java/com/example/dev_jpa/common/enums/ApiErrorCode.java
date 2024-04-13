package com.example.dev_jpa.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ApiErrorCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "비정상적인 요청입니다.(400)"),
    BAD_REQUEST_FILE(HttpStatus.BAD_REQUEST, "비정상적인 첨부파일입니다.(400)"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "대상이 존재하지 않습니다.(404)"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증에 실패하였습니다.(401)"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "접근 권한이 없습니다.(403)"),
    FORBIDDEN_EXCEED_COUNT(HttpStatus.FORBIDDEN, "접근 권한이 없습니다. 접근 시도 제한 횟수를 초과하였습니다.(403)"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "처리 중 오류가 발생하였습니다.(500)");

    private HttpStatus httpStatus;
    private String message;

    public String toString() {
        return "[" + this.httpStatus.value() + "] :: " + this.name();
    }
}
