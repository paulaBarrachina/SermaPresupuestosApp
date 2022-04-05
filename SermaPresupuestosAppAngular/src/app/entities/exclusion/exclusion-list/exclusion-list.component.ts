import { Component, OnInit } from '@angular/core';
import { Exclusion } from 'src/app/models/exclusion.model';
import { ExclusionService } from 'src/app/services/exclusion.service';

@Component({
  selector: 'app-exclusion-list',
  templateUrl: './exclusion-list.component.html',
  styleUrls: ['./exclusion-list.component.scss']
})
export class ExclusionListComponent implements OnInit {

  exclusiones: Exclusion[] = [];

  display = "none";
  exclusionAEliminar!: number;

  error: boolean = false;
  success: boolean = false;
  mensaje: string = '';

  constructor(protected exclusionService: ExclusionService) { }

  ngOnInit(): void {
    this.exclusionService.obtenerTodasExclusiones().subscribe(resultado=>{
      this.exclusiones = resultado;
    })
  }

  abrirModalEliminar (exclusionId: number) {
    this.display= "block";
    this.exclusionAEliminar = exclusionId;
  }

  cerrarModal () {
    this.display = "none";
  }

  eliminar (exclusionAEliminar: number) {
    this.exclusionService.borrarExclusion(exclusionAEliminar).subscribe(resultado=>{
      this.exclusionService.obtenerTodasExclusiones().subscribe(resultado=>{
        this.exclusiones = resultado;
      })
      this.success = true;
      this.mensaje = "Se ha eliminado correctamente la exclusión";
      this.cerrarModal();
    }, error=>{
      this.error = true;
      this.mensaje = "Se ha producido un error al eliminar el cliente. Error " + error.name;
    })
  }

}
