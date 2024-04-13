package com.example.dev_jpa.common.exception.advice;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @ControllerAdvice(basePackages = {"org.woowa.tmp.pkg"})  --> 해당 패키지 && 하위 패키지내에서 발생되는 예외는 해당 Handler 탐.
 * assignableTypes = {SimpleController.class} class 단위로도 부여 가능.
 * API 과정에서 발생되는 예외처리 설정.
 */
@RestControllerAdvice
public class ApiExceptionAdvice {
    //







}
