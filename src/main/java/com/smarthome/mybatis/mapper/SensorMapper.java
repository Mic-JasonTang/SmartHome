package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.Sensor;

public interface SensorMapper {
    int deleteByPrimaryKey(Integer sensorId);

    int insert(Sensor record);

    int insertSelective(Sensor record);

    Sensor selectByPrimaryKey(Integer sensorId);

    int updateByPrimaryKeySelective(Sensor record);

    int updateByPrimaryKey(Sensor record);
}