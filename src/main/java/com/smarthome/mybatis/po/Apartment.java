package com.smarthome.mybatis.po;

public class Apartment {
    private Integer apartmentId;

    private String apartmentName;

    private String apartmentDesc;

    public Apartment(Integer apartmentId, String apartmentName, String apartmentDesc) {
        this.apartmentId = apartmentId;
        this.apartmentName = apartmentName;
        this.apartmentDesc = apartmentDesc;
    }

    public Apartment() {
        super();
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName == null ? null : apartmentName.trim();
    }

    public String getApartmentDesc() {
        return apartmentDesc;
    }

    public void setApartmentDesc(String apartmentDesc) {
        this.apartmentDesc = apartmentDesc == null ? null : apartmentDesc.trim();
    }
}