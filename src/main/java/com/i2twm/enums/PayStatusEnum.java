package com.i2twm.enums;

import lombok.Getter;

/**
 * @author i2twmx@gmail.com
 * @date 2018/10/21 17:46
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),

    ;
    private Integer code;
    private String message;


    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
