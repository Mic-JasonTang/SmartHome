package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByTelOrEmail(@Param("tel") String tel, @Param("email") String email);

    User selectByTelOrEmailAndPwd(@Param("tel") String tel, @Param("email") String email, @Param("pwd") String pwd);
}