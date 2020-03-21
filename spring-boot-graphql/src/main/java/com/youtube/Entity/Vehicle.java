package com.youtube.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "Vehicle")
@Data
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 100, name = "vehicle_type")
    private String type;
    @Column(length = 100, name = "modelCode")
    private String modelCode;
    @Column(length = 100, name = "brandName")
    private String brandName;
    @Column(length = 100, name = "launchDate")
    private Date launchDate;
}
