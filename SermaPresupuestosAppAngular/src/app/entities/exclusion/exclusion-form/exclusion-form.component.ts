import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Exclusion } from 'src/app/models/exclusion.model';
import { ExclusionService } from 'src/app/services/exclusion.service';

@Component({
  selector: 'app-exclusion-form',
  templateUrl: './exclusion-form.component.html',
  styleUrls: ['./exclusion-form.component.scss']
})
export class ExclusionFormComponent implements OnInit {

  error: boolean = false;
  success: boolean = false;
  mensaje: string = '';

  exclusion: Exclusion = new Exclusion();
  exclusionId?: number;
  modoAlta?: boolean;

  constructor(
    private exclusionService: ExclusionService,
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {


    if (this.route.snapshot.paramMap.get('exclusionId')) {

      this.modoAlta = false;
      this.exclusionId = +this.route.snapshot.paramMap.get('exclusionId')!;
      this.cargarDatosCliente(this.exclusionId);

    } else {

      this.modoAlta = true;
      this.exclusion = new Exclusion();

    }

  }

  cargarDatosCliente(exclusionId: number): void {

    this.exclusionService.obtenerExclusion(exclusionId).subscribe(
      (data: Exclusion) => {
        this.exclusion = data;
      },
      (error) => {
        this.mensaje = "Se ha producido un error al recuperar los datos de la exclusión. Error: " + error.name;
      }
    );
  }

  guardar(): void {

    this.error = false;
    this.success = false;
    this.mensaje = "";
    if (this.modoAlta) {
      this.exclusionService.crearExclusion(this.exclusion).subscribe(
        (data: Exclusion) => {
          this.mensaje = "Se ha guardado correctamente la exclusión. Id: " + data.id;
          this.success = true;
          this.exclusion = new Exclusion();
        }, (err) => {
          console.log(err);
          this.error = true;
          this.mensaje = "Se ha producido un error al guardar la exclusión. Error: " + err.name;
        }
      );
    } else {
      this.exclusionService.editarExclusion(this.exclusion).subscribe(
        (data: Exclusion) => {
          this.router.navigate(["/exclusiones"]);
        }, (err) => {
          console.log(err);
          this.error = true;
          this.mensaje = "Se ha producido un error al modificar la exclusión. Error: " + err.name;
        }
      )
    }
  }
}
