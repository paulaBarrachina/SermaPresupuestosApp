import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente.model';
import { Criteria } from '../models/criteria.model';

@Injectable({
  providedIn: 'root'
})

export class ClienteService {

  constructor(private http: HttpClient) { }


public obtenerTodosClientes(): Observable <Cliente[]> {
  const url = "http://localhost:8080/api/clientes";
  return this.http.get <Cliente[]> (url);
}

public obtenerTodosClientesPaginados(page: number, size: number, sort: string): Observable <Cliente[]> {
  const paramPageable = "?page=" + page + "&size=" + size + "&sort=" + sort;
  const url = "http://localhost:8080/api/clientes-pag" + paramPageable;
  return this.http.get <Cliente[]> (url);
}

public obtenerTodosClientesPagSpec(page: number, size: number, sort: string, criterias: Criteria[]) {
  const paramPageable = "?page=" + page + "&size=" + size + "&sort=" + sort;
  const url = "http://localhost:8080/api/clientes-spec" + paramPageable;
  return this.http.post<any> (url, criterias);
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

