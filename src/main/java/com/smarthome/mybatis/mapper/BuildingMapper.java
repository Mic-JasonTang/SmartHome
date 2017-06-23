package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.Building;

public interface BuildingMapper {
    int deleteByPrimaryKey(Integer buildingId);

    int insert(Building record);

    int insertSelective(Building record);

    Building selectByPrimaryKey(Integer buildingId);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
}