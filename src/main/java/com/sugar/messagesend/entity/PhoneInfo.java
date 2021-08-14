package com.sugar.messagesend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description：短信实体类
 * @Auther： 一枚方糖
 * @Date： /08/14/16:20/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneInfo {
    private Integer id;
    private String phone;
    private String content;
    private Date sendTime;
}
