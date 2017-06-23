package com.smarthome.mybatis.po;

public class Room {
    private Integer roomId;

    private String roomType;

    private Integer roomOrder;

    private String roomDesc;

    public Room(Integer roomId, String roomType, Integer roomOrder, String roomDesc) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomOrder = roomOrder;
        this.roomDesc = roomDesc;
    }

    public Room() {
        super();
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public Integer getRoomOrder() {
        return roomOrder;
    }

    public void setRoomOrder(Integer roomOrder) {
        this.roomOrder = roomOrder;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc == null ? null : roomDesc.trim();
    }
}