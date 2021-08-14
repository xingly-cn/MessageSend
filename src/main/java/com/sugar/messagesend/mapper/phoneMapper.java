package com.sugar.messagesend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description：短信数据库接口
 * @Auther： 一枚方糖
 * @Date： /08/14/16:21/
 */
@Mapper
public interface phoneMapper {

    @Insert("insert into phonetable (id,phone,content,sendTime)  VALUES (null,#{mobile},#{param},now())")
    public int insertPhoneMessage(String param ,String mobile);

}
