import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente.model';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.scss']
})
export class ClienteListComponent implements OnInit {

  clientes: Cliente[] = [];

  display = "none";
  clienteAEliminar!: number;

  error: boolean = false;
  success: boolean = false;
  mensaje: string = '';

  constructor(protected clienteService: ClienteService) { }

  ngOnInit(): void {
    this.clienteService.obtenerTodosClientes().subscribe(resultado=>{
      this.clientes = resultado;
    })
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

}
