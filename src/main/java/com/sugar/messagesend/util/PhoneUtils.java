package com.sugar.messagesend.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sugar.messagesend.common.PhoneConfig;

/**
 * @Description：拼接短信参数工具
 * @Auther： 一枚方糖
 * @Date： /08/14/18:23/
 */
public class PhoneUtils {
    public static String ToJsonStr(String param,String mobile) {
        JSONObject JsonData = JSONUtil.createObj();
        JsonData.put("sid",PhoneConfig.SID);
        JsonData.put("token",PhoneConfig.TOKEN);
        JsonData.put("appid",PhoneConfig.APPID);
        JsonData.put("templateid",PhoneConfig.TEMPLATED);
        JsonData.put("param",param);
        JsonData.put("mobile",mobile);
        return JSONUtil.toJsonStr(JsonData);
    }
}
