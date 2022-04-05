package com.example.SermaPresupuestosApp.service.impl;


import com.example.SermaPresupuestosApp.model.Exclusion;
import com.example.SermaPresupuestosApp.repository.ExclusionRepository;
import com.example.SermaPresupuestosApp.service.IExclusionService;
import com.example.SermaPresupuestosApp.service.dto.ExclusionDTO;
import com.example.SermaPresupuestosApp.service.mapper.ModelMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;


@Service
public class ExclusionService implements IExclusionService {

    private ExclusionRepository exclusionRepository;

    public ExclusionService (ExclusionRepository exclusionRepository) {
        this.exclusionRepository = exclusionRepository;
    }


    @Override
    public List<ExclusionDTO> obtenerTodas() {
        List<Exclusion> exclusiones = exclusionRepository.findAll();
        return ModelMapperUtils.mapAll(exclusiones, ExclusionDTO.class) ;
    }

    @Override
    public ExclusionDTO obtenerUna(Long id) {
        Optional<Exclusion> exclusionOptional = exclusionRepository.findById(id);
        if (exclusionOptional.isPresent()) {
            return ModelMapperUtils.map(exclusionOptional.get(), ExclusionDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public ExclusionDTO guardar(ExclusionDTO exclusionDTO) {
        Exclusion exclusionEntidad = ModelMapperUtils.map(exclusionDTO, Exclusion.class);
        exclusionEntidad = exclusionRepository.save(exclusionEntidad);
        return ModelMapperUtils.map(exclusionEntidad, ExclusionDTO.class);
    }

    @Override
    public void borrar(Long id) {
        Optional<Exclusion> exclusionOptional = exclusionRepository.findById(id);
        if (exclusionOptional.isPresent()){
            exclusionRepository.delete(exclusionOptional.get());
        }else {
            System.out.println("La exclusión con id: +id + no existe");
        }
    }
}
