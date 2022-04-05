package com.example.SermaPresupuestosApp.service.impl;


import com.example.SermaPresupuestosApp.model.Cliente;
import com.example.SermaPresupuestosApp.repository.ClienteRepository;
import com.example.SermaPresupuestosApp.service.IClienteService;
import com.example.SermaPresupuestosApp.service.dto.ClienteDTO;
import com.example.SermaPresupuestosApp.service.mapper.ModelMapperUtils;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService (ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }


    @Override
    public List<ClienteDTO> obtenerTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ModelMapperUtils.mapAll(clientes, ClienteDTO.class);
    }

    @Override
    public ClienteDTO obtenerUno(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()){
            return ModelMapperUtils.map(clienteOptional.get(), ClienteDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public ClienteDTO guardar(ClienteDTO clienteDTO) {
        Cliente clienteEntidad = ModelMapperUtils.map(clienteDTO, Cliente.class);
        clienteEntidad = clienteRepository.save(clienteEntidad);
        return ModelMapperUtils.map(clienteEntidad, ClienteDTO.class);
    }

    @Override
    public void borrar(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.delete(clienteOptional.get());
        } else {
            System.out.println("El cliente con el id: +id + no existe");
        }
    }
}
