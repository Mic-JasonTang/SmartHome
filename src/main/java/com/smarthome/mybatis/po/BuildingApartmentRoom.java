package com.smarthome.mybatis.po;

public class BuildingApartmentRoom {
    private Integer barId;

    private Integer baId;

    private Integer roomId;

    public BuildingApartmentRoom(Integer barId, Integer baId, Integer roomId) {
        this.barId = barId;
        this.baId = baId;
        this.roomId = roomId;
    }

    public BuildingApartmentRoom() {
        super();
    }

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public Integer getBaId() {
        return baId;
    }

    public void setBaId(Integer baId) {
        this.baId = baId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}