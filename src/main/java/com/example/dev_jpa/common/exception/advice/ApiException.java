package com.example.dev_jpa.common.exception.advice;

import com.example.dev_jpa.common.enums.ApiErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {
    //Excepion 발생 time
    private Date apiExceptionDate;
    private ApiErrorCode apiErrorCode;
    private String apiMessage;
}
