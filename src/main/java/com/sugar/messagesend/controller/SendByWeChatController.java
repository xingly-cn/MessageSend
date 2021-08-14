package com.sugar.messagesend.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.sugar.messagesend.common.ToResult;
import com.sugar.messagesend.util.WeChatUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description：WeChat推送控制器
 * @Auther： 一枚方糖
 * @Date： /08/14/21:20/
 */
@Controller
public class SendByWeChatController {
    String URL = "http://www.pushplus.plus/send";

    /**
     * WeChat推送
     * @param title 标题
     * @param content 内容
     * @param webhook 钩子（详情见pushplus开发文档）
     * @return
     */
    @ApiOperation(value = "发送微信",httpMethod = "POST")
    @RequestMapping("/wechat/send")
    @ResponseBody
    public ToResult weChatSend(@RequestParam String title,@RequestParam String content,@RequestParam String webhook) {
        String DATA = WeChatUtils.ToJsonStr(title, content, webhook);
        String result = HttpRequest.post(URL).body(DATA).execute().body();
        System.out.println(result);
        return new ToResult(200,"Send Ok",1, JSONObject.parseObject(result));
    }
}
