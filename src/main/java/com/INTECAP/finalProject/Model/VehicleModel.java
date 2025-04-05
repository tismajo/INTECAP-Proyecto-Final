package com.INTECAP.finalProject.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "v_plate", length = 6, nullable = false, unique = true)
    private String vPlate;

    @ManyToOne
    @JoinColumn(name = "v_color")
    private ColorModel vColor;

    @ManyToOne
    @JoinColumn(name = "v_type")
    private TypeModel vType;

    @Column(name = "entrance_time", nullable = false)
    private LocalDateTime entranceTime;

    @Column(name = "exit_time")
    private LocalDateTime exitTime;

    public VehicleModel(Integer id, String vPlate, ColorModel vColor, TypeModel vType, LocalDateTime entranceTime, LocalDateTime exitTime) {
        this.id = id;
        this.vPlate = vPlate;
        this.vColor = vColor;
        this.vType = vType;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
    }

    public VehicleModel() {

    }

    public Integer getId() {
        return id;
    }

    public String getvPlate() {
        return vPlate;
    }

    public ColorModel getvColor() {
        return vColor;
    }

    public TypeModel getvType() {
        return vType;
    }

    public LocalDateTime getEntranceTime() {
        return entranceTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setvPlate(String vPlate) {
        this.vPlate = vPlate;
    }

    public void setvColor(ColorModel vColor) {
        this.vColor = vColor;
    }

    public void setvType(TypeModel vType) {
        this.vType = vType;
    }

    public void setEntranceTime(LocalDateTime entranceTime) {
        this.entranceTime = entranceTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
