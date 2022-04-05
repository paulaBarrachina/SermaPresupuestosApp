import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente.model';
import { ClienteService } from 'src/app/services/cliente.service';


@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.scss']
})
export class ClienteFormComponent implements OnInit {

  error: boolean = false;
  success: boolean = false;
  mensaje: string = '';

  cliente: Cliente = new Cliente();
  clienteId?: number;
  modoAlta?: boolean;

  constructor(
    private clienteService: ClienteService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {


    if (this.route.snapshot.paramMap.get('clienteId')) {

      this.modoAlta = false;
      this.clienteId = +this.route.snapshot.paramMap.get('clienteId')!;
      this.cargarDatosCliente(this.clienteId);

    } else {

      this.modoAlta = true;
      this.cliente = new Cliente();

    }

  }

  cargarDatosCliente(clienteId: number): void {

    this.clienteService.obtenerCliente(clienteId).subscribe(
      (data: Cliente) => {
        this.cliente = data;
      },
      (err) => {
        this.mensaje = "Se ha producido un error al recuperar los datos del cliente. Error: " + err.name;
      });
  }

  guardar(): void {

    this.error = false;
    this.success = false;
    this.mensaje = "";
    if (this.modoAlta) {
      this.clienteService.crearCliente(this.cliente).subscribe(
        (data: Cliente) => {
          this.mensaje = "Se ha guardado correctamente el cliente. Id: " + data.id;
          this.success = true;
          this.cliente = new Cliente();
        }, (err) => {
          console.log(err);
          this.error = true;
          this.mensaje = "Se ha producido un error al guardar el cliente. Error: " + err.name;
        }
      );
    } else {
      this.clienteService.editarCliente(this.cliente).subscribe(
        (data: Cliente) => {
          this.router.navigate(["/clientes"]);
        }, (err) => {
          console.log(err);
          this.error = true;
          this.mensaje = "Se ha producido un error al modificar el cliente. Error: " + err.name;
        }
      )
    }
  }
}
