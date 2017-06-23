package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.Apartment;

public interface ApartmentMapper {
    int deleteByPrimaryKey(Integer apartmentId);

    int insert(Apartment record);

    int insertSelective(Apartment record);

    Apartment selectByPrimaryKey(Integer apartmentId);

    int updateByPrimaryKeySelective(Apartment record);

    int updateByPrimaryKey(Apartment record);
}