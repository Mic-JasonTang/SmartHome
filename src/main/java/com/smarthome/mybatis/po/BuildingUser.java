package com.smarthome.mybatis.po;

public class BuildingUser {
    private Integer buId;

    private Integer buildingId;

    private Integer userId;

    public BuildingUser(Integer buId, Integer buildingId, Integer userId) {
        this.buId = buId;
        this.buildingId = buildingId;
        this.userId = userId;
    }

    public BuildingUser() {
        super();
    }

    public Integer getBuId() {
        return buId;
    }

    public void setBuId(Integer buId) {
        this.buId = buId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}