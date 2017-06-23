package com.smarthome.mybatis.po;

public class Sensor {
    private Integer sensorId;

    private String sensorType;

    private String sensorName;

    private String sensorDesc;

    public Sensor(Integer sensorId, String sensorType, String sensorName, String sensorDesc) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.sensorName = sensorName;
        this.sensorDesc = sensorDesc;
    }

    public Sensor() {
        super();
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType == null ? null : sensorType.trim();
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName == null ? null : sensorName.trim();
    }

    public String getSensorDesc() {
        return sensorDesc;
    }

    public void setSensorDesc(String sensorDesc) {
        this.sensorDesc = sensorDesc == null ? null : sensorDesc.trim();
    }
}