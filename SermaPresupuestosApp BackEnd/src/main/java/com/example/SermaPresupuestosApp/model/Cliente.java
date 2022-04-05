package com.example.SermaPresupuestosApp.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table (name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String nombre;
    @Column
    private String direccion;
}
