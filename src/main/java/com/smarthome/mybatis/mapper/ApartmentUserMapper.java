package com.smarthome.mybatis.mapper;

import com.smarthome.mybatis.po.ApartmentUser;

public interface ApartmentUserMapper {
    int deleteByPrimaryKey(Integer auId);

    int insert(ApartmentUser record);

    int insertSelective(ApartmentUser record);

    ApartmentUser selectByPrimaryKey(Integer auId);

    int updateByPrimaryKeySelective(ApartmentUser record);

    int updateByPrimaryKey(ApartmentUser record);

    /**
     * 根据userId查询公寓
     * @param userId
     * @return
     */
    ApartmentUser selectByUserId(int userId);
}