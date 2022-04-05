package com.example.SermaPresupuestosApp.resource;

import com.example.SermaPresupuestosApp.service.IClienteService;
import com.example.SermaPresupuestosApp.service.dto.ClienteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteResource {

    private IClienteService clienteService;

    public ClienteResource(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @CrossOrigin
    @GetMapping ("/clientes")
    public List<ClienteDTO> obtenerTodosClientes() {
        List<ClienteDTO> clientes = this.clienteService.obtenerTodos();
        return clienteService.obtenerTodos();
    }

    @CrossOrigin
    @GetMapping ("/clientes/{id}")
    public ClienteDTO obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerUno(id);
    }

    @CrossOrigin
    @PostMapping ("/clientes")
    public ClienteDTO crearCliente (@RequestBody ClienteDTO clienteDTO) {
        return clienteService.guardar(clienteDTO);
    }

    @CrossOrigin
    @PutMapping ("/clientes")
    public ClienteDTO editarCliente (@RequestBody ClienteDTO clienteDTO) {
        return clienteService.guardar(clienteDTO);
    }

    @CrossOrigin
    @DeleteMapping ("/clientes/{id}")
    public void borrarCliente (@PathVariable Long id) {
        clienteService.borrar(id);
    }

}
