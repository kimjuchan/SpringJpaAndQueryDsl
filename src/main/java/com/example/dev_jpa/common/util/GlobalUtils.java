package com.example.dev_jpa.common.util;

import org.apache.tika.utils.StringUtils;

public class GlobalUtils {

    public static boolean isBlankByParam(String data){
        return !StringUtils.isBlank(data);
    }
}
