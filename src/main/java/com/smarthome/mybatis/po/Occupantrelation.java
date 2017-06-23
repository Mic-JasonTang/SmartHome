package com.smarthome.mybatis.po;

public class Occupantrelation {
    private Integer occupantrelationId;

    private Integer userId;

    private Integer apartmentId;

    private String relationshio;

    public Occupantrelation(Integer occupantrelationId, Integer userId, Integer apartmentId, String relationshio) {
        this.occupantrelationId = occupantrelationId;
        this.userId = userId;
        this.apartmentId = apartmentId;
        this.relationshio = relationshio;
    }

    public Occupantrelation() {
        super();
    }

    public Integer getOccupantrelationId() {
        return occupantrelationId;
    }

    public void setOccupantrelationId(Integer occupantrelationId) {
        this.occupantrelationId = occupantrelationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getRelationshio() {
        return relationshio;
    }

    public void setRelationshio(String relationshio) {
        this.relationshio = relationshio == null ? null : relationshio.trim();
    }
}