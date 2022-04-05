import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Articulo } from '../models/articulo.model';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

  constructor(private http: HttpClient) { }


public obtenerTodosArticulos(): Observable <Articulo[]> {
  const url = "http://localhost:8080/api/articulos";
  return this.http.get <Articulo[]> (url);
}

public obtenerArticulo(id: number): Observable <Articulo> {
  const url = "http://localhost:8080/api/articulos/" + id;
  return this.http.get <Articulo> (url);
}

public crearArticulo(articulo: Articulo): Observable <Articulo> {
  const url = "http://localhost:8080/api/articulos";
  return this.http.post(url, articulo);
}

public editarArticulo(articulo: Articulo): Observable <Articulo> {
  const url = "http://localhost:8080/api/articulos";
  return this.http.put(url, articulo);
}

public borrarArticulo(id: number): Observable<void> {
  const url = "http://localhost:8080/api/articulos/" + id;
  return this.http.delete<void>(url);
}

}

