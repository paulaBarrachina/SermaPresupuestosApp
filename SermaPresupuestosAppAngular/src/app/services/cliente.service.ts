import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente.model';

@Injectable({
  providedIn: 'root'
})

export class ClienteService {

  constructor(private http: HttpClient) { }


public obtenerTodosClientes(): Observable <Cliente[]> {
  const url = "http://localhost:8080/api/clientes";
  return this.http.get <Cliente[]> (url);
}

public obtenerCliente(id: number): Observable <Cliente> {
  const url = "http://localhost:8080/api/clientes/" + id;
  return this.http.get <Cliente> (url);
}

public crearCliente(cliente: Cliente): Observable <Cliente> {
  const url = "http://localhost:8080/api/clientes";
  return this.http.post(url, cliente);
}

public editarCliente(cliente: Cliente): Observable <Cliente> {
  const url = "http://localhost:8080/api/clientes";
  return this.http.put(url, cliente);
}

public borrarCliente(id: number): Observable<void> {
  const url = "http://localhost:8080/api/clientes/" + id;
  return this.http.delete<void>(url);
}

}

