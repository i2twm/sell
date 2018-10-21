package com.i2twm.enums;

import lombok.Getter;

/**
 * 商品上架状态
 * @author i2twmx@gmail.com
 * @date 2018/10/21 12:32
 */
@Getter
public enum PruductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String message;

    PruductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
