package com.sugar.messagesend.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.sugar.messagesend.common.ToResult;
import com.sugar.messagesend.mapper.wechatMapper;
import com.sugar.messagesend.util.WeChatUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = "SendByWeChatController",description = "微信管理")
@Controller
public class SendByWeChatController {
    @Autowired
    wechatMapper wechatMapper;
    String URL = "http://www.pushplus.plus/send";  // 微信推送地址

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
        String DATA = WeChatUtils.ToJsonStr(title, content, webhook);   // 拼接请求参数
        String result = HttpRequest.post(URL).body(DATA).execute().body();  // 请求微信接口
        wechatMapper.insertWeChatMessage(title,content,webhook);  // 存入微信数据库
        return new ToResult(200,"Send Ok",1, JSONObject.parseObject(result));
    }


}
