package com.sugar.messagesend.controller;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.sugar.messagesend.common.ToResult;
import com.sugar.messagesend.mapper.phoneMapper;
import com.sugar.messagesend.util.PhoneUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = "SendByPhoneController",description = "短信管理")
@Controller
public class SendByPhoneController {
    @Autowired
    phoneMapper phoneMapper;
    String URL = "https://open.ucpaas.com/ol/sms/sendsms";  // 短信请求地址

    /**
     * 短信发送
     * @param param 短信内容
     * @param mobile 手机号
     * @return
     */
    @ApiOperation(value = "发送短信",httpMethod = "GET")
    @RequestMapping("/phone/send")
    @ResponseBody
    public ToResult phoneSend(@RequestParam String param,@RequestParam String mobile){
        String DATA = PhoneUtils.ToJsonStr(param,mobile);   // 拼接请求参数
        String result = HttpRequest.post(URL).body(DATA).execute().body();  // 请求短信接口
        phoneMapper.insertPhoneMessage(param, mobile);  // 存入短信数据库
        return new ToResult(200,"Send Ok",1,JSONUtil.parseObj(result));
    }
}
