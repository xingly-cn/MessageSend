package com.sugar.messagesend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description：WeChat数据库接口
 * @Auther： 一枚方糖
 * @Date： /08/14/21:46/
 */
@Mapper
public interface wechatMapper {

    @Insert("insert into wechattable (id,title,content,webhook,sendTime)  VALUES (null,#{title},#{content},#{webhook},now())")
    public int insertWeChatMessage(String title,String content,String webhook);
    
}
