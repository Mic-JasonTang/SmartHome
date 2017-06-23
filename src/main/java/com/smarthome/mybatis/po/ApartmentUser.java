package com.smarthome.mybatis.po;

public class ApartmentUser {
    private Integer auId;

    private Integer apartmentId;

    private Integer userId;

    public ApartmentUser(Integer auId, Integer apartmentId, Integer userId) {
        this.auId = auId;
        this.apartmentId = apartmentId;
        this.userId = userId;
    }

    public ApartmentUser() {
        super();
    }

    public Integer getAuId() {
        return auId;
    }

    public void setAuId(Integer auId) {
        this.auId = auId;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}