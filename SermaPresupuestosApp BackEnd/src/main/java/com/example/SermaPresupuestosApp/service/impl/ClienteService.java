package com.example.SermaPresupuestosApp.service.impl;


import com.example.SermaPresupuestosApp.model.Cliente;
import com.example.SermaPresupuestosApp.repository.ClienteRepository;
import com.example.SermaPresupuestosApp.repository.spec.ClienteSpec;
import com.example.SermaPresupuestosApp.repository.spec.SearchCriteria;
import com.example.SermaPresupuestosApp.service.IClienteService;
import com.example.SermaPresupuestosApp.service.dto.ClienteDTO;
import com.example.SermaPresupuestosApp.service.mapper.ModelMapperUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ClienteDTO> obtenerTodosPaginado(Pageable pageable) {
        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        Page<ClienteDTO> dtoPage = clientes.map(cliente ->ModelMapperUtils.map(cliente, ClienteDTO.class));
        return dtoPage;
    }

    @Override
    public Page<ClienteDTO> obtenerTodosPagSpec(Pageable pageable, SearchCriteria[] searchCriteria) {
        ClienteSpec spec = new ClienteSpec();
        for (SearchCriteria criteria: searchCriteria) {
            spec.add(criteria);
        }
        Page<Cliente> clientes = clienteRepository.findAll(spec, pageable);
        Page<ClienteDTO> clienteDTOS = clientes.map(cliente -> ModelMapperUtils.map(cliente, ClienteDTO.class));
        return clienteDTOS;
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
