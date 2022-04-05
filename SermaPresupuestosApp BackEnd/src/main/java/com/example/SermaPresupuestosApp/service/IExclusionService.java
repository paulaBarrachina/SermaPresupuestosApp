package com.example.SermaPresupuestosApp.service;

import com.example.SermaPresupuestosApp.service.dto.ExclusionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExclusionService {
    public List<ExclusionDTO> obtenerTodas ();
    public ExclusionDTO obtenerUna (Long id);
    public ExclusionDTO guardar (ExclusionDTO exclusionDTO);
    public void borrar (Long id);
}
