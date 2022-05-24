import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Articulo } from 'src/app/models/articulo.model';
import { ArticuloService } from 'src/app/services/articulo.service';

@Component({
  selector: 'app-articulo-form',
  templateUrl: './articulo-form.component.html',
  styleUrls: ['./articulo-form.component.scss']
})
export class ArticuloFormComponent implements OnInit {

  error: boolean = false;
  success: boolean = false;
  mensaje: string = '';

  articulo: Articulo = new Articulo();
  articuloId?: number;
  modoAlta?: boolean;

  constructor(
    private articuloService: ArticuloService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {


    if (this.route.snapshot.paramMap.get('articuloId')) {

      this.modoAlta = false;
      this.articuloId = +this.route.snapshot.paramMap.get('articuloId')!;
      this.cargarDatosArticulo(this.articuloId);

    } else {

      this.modoAlta = true;
      this.articulo = new Articulo();

    }

  }

  cargarDatosArticulo(articuloId: number): void {

    this.articuloService.obtenerArticulo(articuloId).subscribe(
      (data: Articulo) => {
        this.articulo = data;
      },
      (err) => {
        this.mensaje = "Se ha producido un error al recuperar los datos del artículo. Error: " + err.name;
      });
  }

  guardar(): void {

    this.error = false;
    this.success = false;
    this.mensaje = "";

    if (this.modoAlta) {
      this.articuloService.crearArticulo(this.articulo).subscribe(
        (data: Articulo) => {
          this.mensaje = "Se ha guardado correctamente el artículo. Id: " + data.id;
          this.success = true;
          this.articulo = new Articulo();
        }, (err) => {
          console.log(err);
          this.error = true;
          this.mensaje = "Se ha producido un error al guardar el artículo. Error: " + err.error;
        }
      );
    } else {
      this.articuloService.editarArticulo(this.articulo).subscribe(
        (data: Articulo) => {
          this.router.navigate(["/articulos"]);
        }, (err) => {
          console.log(err);
          this.error = true;
          this.mensaje = "Se ha producido un error al modificar el artículo. Error: " + err.name;
        }
      )
    }
  }
}
