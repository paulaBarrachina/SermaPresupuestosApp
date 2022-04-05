package com.example.SermaPresupuestosApp.service;


import com.example.SermaPresupuestosApp.service.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {
    public List<ClienteDTO> obtenerTodos();
    public ClienteDTO obtenerUno(Long id);
    public ClienteDTO guardar (ClienteDTO clienteDTO);
    public void borrar (Long id);
}
