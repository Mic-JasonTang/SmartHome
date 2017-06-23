package com.smarthome.mybatis.po;

import java.util.Date;

public class SensorData {
    private Integer slId;

    private Integer sensorId;

    private Integer roomId;

    private Date logtime;

    private String sensorValue;

    public SensorData(Integer slId, Integer sensorId, Integer roomId, Date logtime, String sensorValue) {
        this.slId = slId;
        this.sensorId = sensorId;
        this.roomId = roomId;
        this.logtime = logtime;
        this.sensorValue = sensorValue;
    }

    public SensorData() {
        super();
    }

    public Integer getSlId() {
        return slId;
    }

    public void setSlId(Integer slId) {
        this.slId = slId;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue == null ? null : sensorValue.trim();
    }
}