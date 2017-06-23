package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.BuildingUser;

public interface BuildingUserMapper {
    int deleteByPrimaryKey(Integer buId);

    int insert(BuildingUser record);

    int insertSelective(BuildingUser record);

    BuildingUser selectByPrimaryKey(Integer buId);

    int updateByPrimaryKeySelective(BuildingUser record);

    int updateByPrimaryKey(BuildingUser record);
}