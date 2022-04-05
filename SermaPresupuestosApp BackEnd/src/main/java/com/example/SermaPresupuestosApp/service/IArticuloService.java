package com.example.SermaPresupuestosApp.service;

import com.example.SermaPresupuestosApp.service.dto.ArticuloDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IArticuloService {
    public List<ArticuloDTO> obtenerTodos();
    public ArticuloDTO obtenerUno(Long id);
    public ArticuloDTO guardar (ArticuloDTO articuloDTO);
    public void borrar (Long id);
}
