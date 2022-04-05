package com.example.SermaPresupuestosApp.service.impl;

import com.example.SermaPresupuestosApp.model.Articulo;
import com.example.SermaPresupuestosApp.repository.ArticuloRepository;
import com.example.SermaPresupuestosApp.service.IArticuloService;
import com.example.SermaPresupuestosApp.service.dto.ArticuloDTO;
import com.example.SermaPresupuestosApp.service.mapper.ModelMapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService implements IArticuloService {

    private ArticuloRepository articuloRepository;

    public ArticuloService (ArticuloRepository articuloRepository){
        this.articuloRepository = articuloRepository;
    }


    @Override
    public List<ArticuloDTO> obtenerTodos() {
        List<Articulo> articulos = articuloRepository.findAll();
        return ModelMapperUtils.mapAll(articulos, ArticuloDTO.class);
    }

    @Override
    public ArticuloDTO obtenerUno(Long id) {
        Optional<Articulo> articuloOptional = articuloRepository.findById(id);
        if (articuloOptional.isPresent()){
            return ModelMapperUtils.map(articuloOptional.get(), ArticuloDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public ArticuloDTO guardar(ArticuloDTO articuloDTO) {
        Articulo articuloEntidad = ModelMapperUtils.map(articuloDTO, Articulo.class);
        articuloEntidad = articuloRepository.save(articuloEntidad);
        return ModelMapperUtils.map(articuloEntidad, ArticuloDTO.class);
    }

    @Override
    public void borrar(Long id) {
        Optional<Articulo> articuloOptional = articuloRepository.findById(id);
        if (articuloOptional.isPresent()) {
            articuloRepository.delete(articuloOptional.get());
        } else {
            System.out.println("El artículo con el id: +id + no existe");
        }
    }
}
