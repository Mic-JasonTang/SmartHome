package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.Occupantrelation;

public interface OccupantrelationMapper {
    int deleteByPrimaryKey(Integer occupantrelationId);

    int insert(Occupantrelation record);

    int insertSelective(Occupantrelation record);

    Occupantrelation selectByPrimaryKey(Integer occupantrelationId);

    int updateByPrimaryKeySelective(Occupantrelation record);

    int updateByPrimaryKey(Occupantrelation record);
}