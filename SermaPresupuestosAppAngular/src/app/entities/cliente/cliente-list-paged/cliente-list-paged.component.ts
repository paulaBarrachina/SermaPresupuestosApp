import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente.model';
import { Criteria } from 'src/app/models/criteria.model';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-list-paged',
  templateUrl: './cliente-list-paged.component.html',
  styleUrls: ['./cliente-list-paged.component.scss']
})
export class ClienteListPagedComponent implements OnInit {

  clientes: Cliente[] = [];

  display = "none";
  clienteAEliminar!: number;

  error: boolean = false;
  success: boolean = false;
  mensaje: string = '';

//paginación
  page: number = 0;
  size: number = 5;
  sort: string = "id,asc";

  first: boolean = false;
  last: boolean = false;
  totalPages: number = 0;
  totalElements: number = 0;

  //filtros 
  filtros: Criteria[] = [];
  filtroId: number = 0;
  filtroNombre: string = "";

  constructor(protected clienteService: ClienteService) { }

  ngOnInit(): void {
    this.obtenerTodosClientes(this.page, this.size, this.sort)
  }
    
  obtenerTodosClientes(page: number, size: number, sort: string) {
    this.clienteService.obtenerTodosClientesPaginados(page, size, sort).subscribe(data => this.paginateCliente(data));
  }

  obtenerTodosClientesSpec(page: number, size: number, sort: string, filtros:Criteria[]) {
    this.clienteService.obtenerTodosClientesPagSpec(page, size, sort, filtros).subscribe(data => this.paginateCliente(data));
  } 
  
  navegarAnterior() {
    this.page = this.page - 1;
    this.obtenerTodosClientesSpec(this.page, this.size, this.sort, this.filtros);
  }

  navegarSiguiente() {
    this.page = this.page + 1;
    this.obtenerTodosClientesSpec(this.page, this.size, this.sort, this.filtros);
  }

  buscar(){
    //MONTAR FILTROS
    this.filtros = [];
    if(this.filtroId !== 0) {
      let idCriteria: Criteria = new Criteria();
      idCriteria.key = "number";
      idCriteria.value = this.filtroId;
      idCriteria.operation = "EQUAL";
      this.filtros.push(idCriteria);
    }

    if(this.filtroNombre !== "") {
      let nombreCriteria: Criteria = new Criteria();
      nombreCriteria.key = "nombre";
      nombreCriteria.value = this.filtroNombre;
      nombreCriteria.operation = "MATCH";
      this.filtros.push(nombreCriteria);
    }

    //LLAMAR AL API
    this.obtenerTodosClientesSpec(this.page, this.size, this.sort, this.filtros);
  }

  abrirModalEliminar (clienteId: number) {
    this.display= "block";
    this.clienteAEliminar = clienteId;
  }

  cerrarModal () {
    this.display = "none";
  }

  eliminar (clienteAEliminar: number) {
    this.clienteService.borrarCliente(clienteAEliminar).subscribe(resultado=>{
      this.clienteService.obtenerTodosClientes().subscribe(resultado=>{
        this.clientes = resultado;
      })
      this.success = true;
      this.mensaje = "Se ha eliminado correctamente el cliente";
      this.cerrarModal();
    },error=> {
      this.error = true;
      this.mensaje = "Se ha producido un error al eliminar el cliente. Error " + error.name;
    })
  }

  private paginateCliente (data: any) {
    this.clientes = data.content;
    this.first = data.first;
    this.last = data.last;
    this.totalElements = data.totalElements;
    this.totalPages = data.totalPages;
  }

}
