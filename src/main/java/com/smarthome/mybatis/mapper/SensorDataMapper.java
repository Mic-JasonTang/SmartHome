package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.SensorData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SensorDataMapper {
    int deleteByPrimaryKey(Integer slId);

    int insert(SensorData record);

    int insertSelective(SensorData record);

    SensorData selectByPrimaryKey(Integer slId);

    int updateByPrimaryKeySelective(SensorData record);

    int updateByPrimaryKey(SensorData record);

    /**
     * 根据sensorId查看 数据集
     * @param sensorId
     * @return
     */
    List<SensorData> selectListBySensorId(@Param("sensorId") int sensorId, @Param("length") int length);
}