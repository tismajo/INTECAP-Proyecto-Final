package com.INTECAP.finalProject.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "colors")
public class ColorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_id;

    @Column(nullable = false, unique = true)
    private String c_name;

    // Getters y setters
    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}
