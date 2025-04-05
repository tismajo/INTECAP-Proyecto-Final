package com.INTECAP.finalProject.Model;

import java.time.LocalDateTime;

public class VehicleModel {
    private String vType;
    private String vPlate;
    private Integer vColor;
    private LocalDateTime entranceTime;
    private LocalDateTime exitTime;

    public VehicleModel(String vType, String vPlate, Integer vColor, LocalDateTime entranceTime, LocalDateTime exitTime) {
        this.vType = vType;
        this.vPlate = vPlate;
        this.vColor = vColor;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
    }

    public VehicleModel() {

    }

    public String getvType() {
        return vType;
    }

    public String getvPlate() {
        return vPlate;
    }

    public Integer getvColor() {
        return vColor;
    }

    public LocalDateTime getEntranceTime() {
        return entranceTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setvType(String vType) {
        this.vType = vType;
    }

    public void setvPlate(String vPlate) {
        this.vPlate = vPlate;
    }

    public void setvColor(Integer vColor) {
        this.vColor = vColor;
    }

    public void setEntranceTime(LocalDateTime entranceTime) {
        this.entranceTime = entranceTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
