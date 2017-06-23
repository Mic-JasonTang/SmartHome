package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.Gpsinfo;

public interface GpsinfoMapper {
    int deleteByPrimaryKey(Integer gpsinfoId);

    int insert(Gpsinfo record);

    int insertSelective(Gpsinfo record);

    Gpsinfo selectByPrimaryKey(Integer gpsinfoId);

    int updateByPrimaryKeySelective(Gpsinfo record);

    int updateByPrimaryKey(Gpsinfo record);
}