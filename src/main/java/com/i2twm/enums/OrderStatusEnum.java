package com.i2twm.enums;

import lombok.Getter;

/**
 * @author i2twmx@gmail.com
 * @date 2018/10/21 17:42
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FILISHED(1,"完结"),
    CANCEL(2,"已取消")
            ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
