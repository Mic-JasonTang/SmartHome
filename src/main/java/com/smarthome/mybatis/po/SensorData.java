package com.smarthome.mybatis.po;

import java.util.Date;

public class SensorData {
    private Integer sdId;

    private Integer sensorId;

    private Integer roomOrder;

    private Date logtime;

    private String sensorValue;

    public SensorData(Integer sdId, Integer sensorId, Integer roomOrder, Date logtime, String sensorValue) {
        this.sdId = sdId;
        this.sensorId = sensorId;
        this.roomOrder = roomOrder;
        this.logtime = logtime;
        this.sensorValue = sensorValue;
    }

    public SensorData() {
        super();
    }

    public Integer getSdId() {
        return sdId;
    }

    public void setSdId(Integer sdId) {
        this.sdId = sdId;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getRoomOrder() {
        return roomOrder;
    }

    public void setRoomOrder(Integer roomOrder) {
        this.roomOrder = roomOrder;
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