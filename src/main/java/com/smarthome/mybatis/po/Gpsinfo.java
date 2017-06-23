package com.smarthome.mybatis.po;

import java.util.Date;

public class Gpsinfo {
    private Integer gpsinfoId;

    private Integer sensorId;

    private Integer userId;

    private Date logtime;

    private Double longtitude;

    private Double lltitude;

    private String location;

    public Gpsinfo(Integer gpsinfoId, Integer sensorId, Integer userId, Date logtime, Double longtitude, Double lltitude, String location) {
        this.gpsinfoId = gpsinfoId;
        this.sensorId = sensorId;
        this.userId = userId;
        this.logtime = logtime;
        this.longtitude = longtitude;
        this.lltitude = lltitude;
        this.location = location;
    }

    public Gpsinfo() {
        super();
    }

    public Integer getGpsinfoId() {
        return gpsinfoId;
    }

    public void setGpsinfoId(Integer gpsinfoId) {
        this.gpsinfoId = gpsinfoId;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLltitude() {
        return lltitude;
    }

    public void setLltitude(Double lltitude) {
        this.lltitude = lltitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }
}