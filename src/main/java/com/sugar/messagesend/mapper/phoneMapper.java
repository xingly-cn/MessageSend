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

    @Insert("insert id,username,phone,content,sendTime into phoneTable values (#{username},#{phone},#{content},#{sendTime})")
    public int insertPhoneMessage();

}
