package com.smarthome.mybatis.po;

public class Building {
    private Integer buildingId;

    private String buildingNo;

    private String buildingName;

    private String buildingDesc;

    public Building(Integer buildingId, String buildingNo, String buildingName, String buildingDesc) {
        this.buildingId = buildingId;
        this.buildingNo = buildingNo;
        this.buildingName = buildingName;
        this.buildingDesc = buildingDesc;
    }

    public Building() {
        super();
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo == null ? null : buildingNo.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getBuildingDesc() {
        return buildingDesc;
    }

    public void setBuildingDesc(String buildingDesc) {
        this.buildingDesc = buildingDesc == null ? null : buildingDesc.trim();
    }
}