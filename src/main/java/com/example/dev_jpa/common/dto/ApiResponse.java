package com.example.dev_jpa.common.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class ApiResponse<T> {

    private static final String SUCCESS_CODE = "200";
    private String resultCode;

    private T resultData;

    public static <T> ApiResponse<T> create(T data){
        return ApiResponse.<T>builder()
                .resultCode(SUCCESS_CODE)
                .resultData(data)
                .build();
    }

}
