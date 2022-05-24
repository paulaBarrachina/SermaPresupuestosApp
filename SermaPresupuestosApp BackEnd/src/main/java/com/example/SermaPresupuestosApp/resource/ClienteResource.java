package com.example.SermaPresupuestosApp.resource;

import com.example.SermaPresupuestosApp.repository.spec.SearchCriteria;
import com.example.SermaPresupuestosApp.service.IClienteService;
import com.example.SermaPresupuestosApp.service.dto.ClienteDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    @GetMapping ("/clientes-pag")
    public Page<ClienteDTO> obtenerTodosClientes(Pageable pageable) {
        return clienteService.obtenerTodosPaginado(pageable);
    }

    @CrossOrigin
    @PostMapping ("clientes-spec")
    public Page<ClienteDTO> obtenerClientesSpec(Pageable pageable, @RequestBody SearchCriteria[] searchCriteria) {
        return clienteService.obtenerTodosPagSpec(pageable, searchCriteria);
    }

    @CrossOrigin
    @GetMapping ("/clientes/{id}")
    public ClienteDTO obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerUno(id);
    }

    @CrossOrigin
    @PostMapping ("/clientes")
    public ResponseEntity crearCliente (@RequestBody ClienteDTO clienteDTO) {

        if (clienteDTO.getNombre() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del cliente no puede estar vacío");
        }

        ClienteDTO clienteInsertado = this.clienteService.guardar(clienteDTO);
        return new ResponseEntity<ClienteDTO>(clienteInsertado, new HttpHeaders(), HttpStatus.CREATED);
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
