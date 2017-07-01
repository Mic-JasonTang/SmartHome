package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.BuildingApartment;

public interface BuildingApartmentMapper {
    int deleteByPrimaryKey(Integer baId);

    int insert(BuildingApartment record);

    int insertSelective(BuildingApartment record);

    BuildingApartment selectByPrimaryKey(Integer baId);

    int updateByPrimaryKeySelective(BuildingApartment record);

    int updateByPrimaryKey(BuildingApartment record);

    /**
     * 根据 公寓Id 查询楼宇-公寓 Id
     * @param apartmentId
     * @return
     */
    BuildingApartment selectByAparamentId(int apartmentId);
}