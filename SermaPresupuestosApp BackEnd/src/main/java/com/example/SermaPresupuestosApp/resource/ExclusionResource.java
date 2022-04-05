package com.example.SermaPresupuestosApp.resource;

import com.example.SermaPresupuestosApp.service.IExclusionService;
import com.example.SermaPresupuestosApp.service.dto.ExclusionDTO;
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
    public ExclusionDTO crearExclusion (@RequestBody ExclusionDTO exclusionDTO) {
        return exclusionService.guardar(exclusionDTO);
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
