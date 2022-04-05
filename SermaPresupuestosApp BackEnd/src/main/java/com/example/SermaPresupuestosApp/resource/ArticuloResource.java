package com.example.SermaPresupuestosApp.resource;
import com.example.SermaPresupuestosApp.service.IArticuloService;
import com.example.SermaPresupuestosApp.service.dto.ArticuloDTO;
import com.example.SermaPresupuestosApp.service.dto.ClienteDTO;
import com.example.SermaPresupuestosApp.service.impl.ArticuloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticuloResource {

    private IArticuloService articuloService;

    public ArticuloResource (IArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @CrossOrigin
    @GetMapping ("/articulos")
    public List<ArticuloDTO> obtenerTodosArticulos() {
        List<ArticuloDTO> clientes = this.articuloService.obtenerTodos();
        return articuloService.obtenerTodos();
    }


    @CrossOrigin
    @GetMapping ("/articulos/{id}")
    public ArticuloDTO obtenerArticulo(@PathVariable Long id) {
        return articuloService.obtenerUno(id);
    }

    @CrossOrigin
    @PostMapping("/articulos")
    public ArticuloDTO crearArticulo (@RequestBody ArticuloDTO articuloDTO) {
        return articuloService.guardar(articuloDTO);
    }

    @CrossOrigin
    @PutMapping ("/articulos")
    public ArticuloDTO editarArticulo (@RequestBody ArticuloDTO articuloDTO) {
        return articuloService.guardar(articuloDTO);
    }

    @CrossOrigin
    @DeleteMapping ("/articulos/{id}")
    public void borrarArticulo (@PathVariable Long id) {
        articuloService.borrar(id);
    }

}
