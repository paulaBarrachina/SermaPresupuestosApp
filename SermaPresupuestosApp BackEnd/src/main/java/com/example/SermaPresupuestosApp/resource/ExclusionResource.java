package com.example.SermaPresupuestosApp.resource;

import com.example.SermaPresupuestosApp.service.IExclusionService;
import com.example.SermaPresupuestosApp.service.dto.ClienteDTO;
import com.example.SermaPresupuestosApp.service.dto.ExclusionDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class ExclusionResource {
    private IExclusionService exclusionService;

    public ExclusionResource (IExclusionService exclusionService){
        this.exclusionService = exclusionService;
    }

    @CrossOrigin
    @GetMapping("/exclusiones")
    public List<ExclusionDTO> obtenerTodasExclusiones() {
        List<ExclusionDTO> exclusiones = this.exclusionService.obtenerTodas();
        return exclusionService.obtenerTodas();
    }

    @CrossOrigin
    @GetMapping("/exclusiones/{id}")
    public ExclusionDTO obtenerExclusion(@PathVariable Long id) {
        return exclusionService.obtenerUna(id);
    }

    @CrossOrigin
    @PostMapping("/exclusiones")
    public ResponseEntity crearExclusion (@RequestBody ExclusionDTO exclusionDTO) {

        if (exclusionDTO.getDescripcion() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("La descripción de la exclusión no puede estar vacía");
        }

        ExclusionDTO exclusionInsertada = this.exclusionService.guardar(exclusionDTO);
        return new ResponseEntity<ExclusionDTO>(exclusionInsertada, new HttpHeaders(), HttpStatus.CREATED);
    }


    @CrossOrigin
    @PutMapping("/exclusiones/")
    public ExclusionDTO editarExclusion (@RequestBody ExclusionDTO exclusionDTO) {
        return exclusionService.guardar(exclusionDTO);
    }

    @CrossOrigin
    @DeleteMapping("/exclusiones/id")
    public void borrarExclusion (@PathVariable Long id) {
       exclusionService.borrar(id);
    }


}
