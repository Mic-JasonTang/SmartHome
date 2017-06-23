package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.SensorData;

public interface SensorDataMapper {
    int deleteByPrimaryKey(Integer slId);

    int insert(SensorData record);

    int insertSelective(SensorData record);

    SensorData selectByPrimaryKey(Integer slId);

    int updateByPrimaryKeySelective(SensorData record);

    int updateByPrimaryKey(SensorData record);
}