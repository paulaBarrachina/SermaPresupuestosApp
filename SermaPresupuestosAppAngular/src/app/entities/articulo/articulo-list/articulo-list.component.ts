import { Component, OnInit } from '@angular/core';
import { Articulo } from 'src/app/models/articulo.model';
import { ArticuloService } from 'src/app/services/articulo.service';

@Component({
  selector: 'app-articulo-list',
  templateUrl: './articulo-list.component.html',
  styleUrls: ['./articulo-list.component.scss']
})
export class ArticuloListComponent implements OnInit {

  articulos: Articulo[] = [];

  display = "none";
  articuloAEliminar!: number;

  error: boolean = false;
  success: boolean = false;
  mensaje: string = '';

  constructor(protected articuloService: ArticuloService) { }

  ngOnInit(): void {
    this.articuloService.obtenerTodosArticulos().subscribe(resultado=>{
      this.articulos = resultado;
    })
  }


  abrirModalEliminar(articuloId: number) {
    this.display= "block";
    this.articuloAEliminar = articuloId;
  }

  cerrarModal () {
    this.display = "none";
  }

  eliminar (articuloAEliminar: number) {
    this.articuloService.borrarArticulo(articuloAEliminar).subscribe(resultado=>{
      this.articuloService.obtenerTodosArticulos().subscribe(resultado=>{
        this.articulos = resultado;
      })
      this.success = true;
      this.mensaje = "Se ha eliminado correctamente el artículo";
      this.cerrarModal();
    },error=> {
      this.error = true;
      this.mensaje = "Se ha producido un error al eliminar el artículo. Error " + error.name;
    })
  }

}
