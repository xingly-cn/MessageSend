package com.sugar.messagesend.controller;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.sugar.messagesend.common.ToResult;
import com.sugar.messagesend.util.PhoneUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @Description：短信发送控制器
 * @Auther： 一枚方糖
 * @Date： /08/14/16:19/
 */

@Controller
public class SendByPhoneController {
    String URL = "https://open.ucpaas.com/ol/sms/sendsms";  // 请求地址


    @RequestMapping("send")
    @ResponseBody
    public ToResult phoneSend(@RequestParam String param,@RequestParam String mobile){
        String DATA = PhoneUtils.ToJsonStr(param,mobile);
        String result = HttpRequest.post(URL).body(DATA).execute().body();
        return new ToResult(200,"Send Ok",1,JSONUtil.parseObj(result));
    }
}
