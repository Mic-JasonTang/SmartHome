package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.BuildingApartmentRoom;

import java.util.List;

public interface BuildingApartmentRoomMapper {
    int deleteByPrimaryKey(Integer barId);

    int insert(BuildingApartmentRoom record);

    int insertSelective(BuildingApartmentRoom record);

    BuildingApartmentRoom selectByPrimaryKey(Integer barId);

    int updateByPrimaryKeySelective(BuildingApartmentRoom record);

    int updateByPrimaryKey(BuildingApartmentRoom record);

    /**
     * 根据 楼宇-公寓 id 查询 roomId
     * @param baId
     * @return
     */
    List<BuildingApartmentRoom> selectByBuildingApartmentId(int baId);
}