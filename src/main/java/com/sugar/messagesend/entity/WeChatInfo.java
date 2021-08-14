package com.sugar.messagesend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description：WeChat实体类
 * @Auther： 一枚方糖
 * @Date： /08/14/21:40/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeChatInfo {
    private Integer id;
    private String title;
    private String content;
    private String webhook;
    private Date sendTime;
}
