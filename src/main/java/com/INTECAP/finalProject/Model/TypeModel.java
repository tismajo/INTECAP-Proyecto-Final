package com.INTECAP.finalProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_types")
public class TypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vt_id;

    @Column(nullable = false, unique = true)
    private String vt_name;

    // Getters y setters
    public Integer getVt_id() {
        return vt_id;
    }

    public void setVt_id(Integer vt_id) {
        this.vt_id = vt_id;
    }

    public String getVt_name() {
        return vt_name;
    }

    public void setVt_name(String vt_name) {
        this.vt_name = vt_name;
    }
}
