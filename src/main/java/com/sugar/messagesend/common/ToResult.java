package com.sugar.messagesend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description：通用返回类型封装
 * @Auther： 一枚方糖
 * @Date： /08/14/16:31/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToResult {
    private Integer code;
    private String msg;
    private Integer count;
    private Object data;
}
