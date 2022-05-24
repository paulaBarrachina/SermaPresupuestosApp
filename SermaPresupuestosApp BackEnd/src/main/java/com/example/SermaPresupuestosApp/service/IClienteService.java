package com.example.SermaPresupuestosApp.service;


import com.example.SermaPresupuestosApp.repository.spec.SearchCriteria;
import com.example.SermaPresupuestosApp.service.dto.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {
    public List<ClienteDTO> obtenerTodos();
    public Page<ClienteDTO> obtenerTodosPaginado(Pageable pageable);
    public Page<ClienteDTO> obtenerTodosPagSpec(Pageable pageable, SearchCriteria[] searchCriteria);
    public ClienteDTO obtenerUno(Long id);
    public ClienteDTO guardar (ClienteDTO clienteDTO);
    public void borrar (Long id);
}
