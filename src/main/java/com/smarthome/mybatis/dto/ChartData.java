package com.smarthome.mybatis.dto;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 7/1/2017 11:08 PM.
 */
public class ChartData {

    /**
     * 时间
     */
    private String name;

    /**
     * 当前数据
     */
    private int y;

    public ChartData() {}

    public ChartData(String name, int y) {
        this.name = name;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
