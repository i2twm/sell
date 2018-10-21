package com.i2twm.VO;

import lombok.Data;

/**
 * http返回的最外层对象
 * @author i2twmx@gmail.com
 * @date 2018/10/21 13:05
 */
@Data
public class ResultVO<T> {
    private Integer code;

    private String message;

    private T date;
}
