package com.INTECAP.finalProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_types")
public class TypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vt_id")
    private Integer id;

    @Column(name = "vt_name", nullable = false, unique = true)
    private String vt_name;

    public Integer getId() {
        return id;
    }

    public void setVt_id(Integer vt_id) {
        this.id = vt_id;
    }

    public String getVt_name() {
        return vt_name;
    }

    public void setVt_name(String vt_name) {
        this.vt_name = vt_name;
    }
}
