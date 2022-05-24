package com.example.SermaPresupuestosApp.model;


import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String descripcionCorta;
    @Column
    private String descripcionLarga;
    @Column (name = "imagen")
    private byte[] image;
    @Column
    private Double coste;
}
