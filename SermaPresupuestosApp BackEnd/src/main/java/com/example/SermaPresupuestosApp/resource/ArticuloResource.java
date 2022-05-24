package com.example.SermaPresupuestosApp.resource;
import com.example.SermaPresupuestosApp.service.IArticuloService;
import com.example.SermaPresupuestosApp.service.dto.ArticuloDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;


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
    public ResponseEntity crearArticulo (@RequestBody ArticuloDTO articuloDTO) {

        if (articuloDTO.getDescripcionCorta() == null) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("El campo Descripción corta no puede estar vacío");
        }

        ArticuloDTO articuloInsertado = this.articuloService.guardar(articuloDTO);
        return new ResponseEntity<ArticuloDTO>(articuloInsertado, new HttpHeaders(), HttpStatus.CREATED);
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
