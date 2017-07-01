package com.smarthome.mybatis.po;

public class BuildingApartment {
    private Integer baId;

    private Integer buildingId;

    private Integer apartmentId;

    public BuildingApartment(Integer baId, Integer buildingId, Integer apartmentId) {
        this.baId = baId;
        this.buildingId = buildingId;
        this.apartmentId = apartmentId;
    }

    public BuildingApartment() {
        super();
    }

    public Integer getBaId() {
        return baId;
    }

    public void setBaId(Integer baId) {
        this.baId = baId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }
}