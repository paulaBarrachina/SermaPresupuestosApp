package com.example.SermaPresupuestosApp.service.dto;

import lombok.Data;

@Data
public class ArticuloDTO {
    private Long id;
    private String descripcionCorta;
    private String descripcionLarga;
    private byte[] image;
    private Number coste;
}
