package com.smarthome.mybatis.dto;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/27/2017 4:54 PM.
 * 传感器数据
 */
public class SensorDataDTO {

    /**
     * 当前数据
     */
    private int curData;

    /**
     * 数据变化量
     */
    private int changeData;

    /**
     * 时间
     */
    private String date;

    public SensorDataDTO() {}

    public SensorDataDTO(int curData) {
        this.curData = curData;
    }

    public SensorDataDTO(int curData, int changeData, String date) {
        this.curData = curData;
        this.changeData = changeData;
        this.date = date;
    }

    public int getCurData() {
        return curData;
    }

    public void setCurData(int curData) {
        this.curData = curData;
    }

    public int getChangeData() {
        return changeData;
    }

    public void setChangeData(int changeData) {
        this.changeData = changeData;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SensorDataDTO{" +
                "curData=" + curData +
                ", changeData=" + changeData +
                ", date='" + date + '\'' +
                '}';
    }
}
