package com.sugar.messagesend.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sugar.messagesend.common.EmailConfig;

/**
 * @Description：拼接Email参数工具
 * @Auther： 一枚方糖
 * @Date： /08/14/22:18/
 */
public class EmailUtils {
    public static String ToJsonStr(String receive,String title,String content) {
        String DATA="?fsyx="+EmailConfig.FSYX+"&yxmm="+EmailConfig.YXMM+"&jsyx="+receive+"&bt="+title+"&nr="+content;
        return DATA;
    }
}
