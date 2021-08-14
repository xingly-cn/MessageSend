package com.sugar.messagesend.util;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sugar.messagesend.common.WeChatConfig;

/**
 * @Description：拼接微信参数工具
 * @Auther： 一枚方糖
 * @Date： /08/14/21:17/
 */
public class WeChatUtils {
    public static String ToJsonStr(String title,String content,String webhook) {
        JSONObject JsonData = JSONUtil.createObj();
        JsonData.put("token", WeChatConfig.TOKEN);
        JsonData.put("title",title);
        JsonData.put("content",content);
        JsonData.put("webhook",webhook);
        return JSONUtil.toJsonStr(JsonData);
    }
}
