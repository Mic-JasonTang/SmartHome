package com.smarthome.mybatis.po;

public class Occupantrelation {
    private Integer occupantrelationId;

    private Integer userId;

    private Integer apartmentId;

    private String relationship;

    private String nickName;

    public Occupantrelation(Integer occupantrelationId, Integer userId, Integer apartmentId, String relationship, String nickName) {
        this.occupantrelationId = occupantrelationId;
        this.userId = userId;
        this.apartmentId = apartmentId;
        this.relationship = relationship;
        this.nickName = nickName;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship == null ? null : relationship.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }
}