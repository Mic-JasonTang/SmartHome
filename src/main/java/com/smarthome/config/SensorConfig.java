package com.smarthome.config;

import org.springframework.context.annotation.Configuration;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/27/2017 5:07 PM.
 * 传感器配置
 */
@Configuration
public class SensorConfig {

    /**
     * 温度传感器Id
     */
    private int temperatureId = 1000;

    /**
     * 湿度传感器Id
     */
    private int humidityId = 1001;

    /**
     * 烟雾传感器Id
     */
    private int smokeId = 1002;

    /**
     * 可燃气体传感器Id
     */
    private int inflammableId = 1003;

    /**
     * 紧急按钮Id
     */
    private int warningButtonId = 1004;

    /**
     * gpsId
     */
    private int gpsId = 1005;

    /**
     * 大门Id
     */
    private int doorId = 1006;

    public int getTemperatureId() {
        return temperatureId;
    }

    public void setTemperatureId(int temperatureId) {
        this.temperatureId = temperatureId;
    }

    public int getHumidityId() {
        return humidityId;
    }

    public void setHumidityId(int humidityId) {
        this.humidityId = humidityId;
    }

    public int getSmokeId() {
        return smokeId;
    }

    public void setSmokeId(int smokeId) {
        this.smokeId = smokeId;
    }

    public int getInflammableId() {
        return inflammableId;
    }

    public void setInflammableId(int inflammableId) {
        this.inflammableId = inflammableId;
    }

    public int getWarningButtonId() {
        return warningButtonId;
    }

    public void setWarningButtonId(int warningButtonId) {
        this.warningButtonId = warningButtonId;
    }

    public int getGpsId() {
        return gpsId;
    }

    public void setGpsId(int gpsId) {
        this.gpsId = gpsId;
    }

    public int getDoorId() {
        return doorId;
    }

    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }
}
