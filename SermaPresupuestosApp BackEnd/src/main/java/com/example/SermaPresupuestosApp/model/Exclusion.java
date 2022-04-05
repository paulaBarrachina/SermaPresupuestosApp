package com.example.SermaPresupuestosApp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "Exclusiones")
@Data
public class Exclusion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String descripcion;
}
