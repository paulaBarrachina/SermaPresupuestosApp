import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exclusion } from '../models/exclusion.model';

@Injectable({
  providedIn: 'root'
})
export class ExclusionService {

  constructor(private http: HttpClient) { }

  public obtenerTodasExclusiones(): Observable<Exclusion[]> {
    const url = "http://localhost:8080/api/exclusiones";
    return this.http.get<Exclusion[]>(url);
  }

  public obtenerExclusion(id: number): Observable<Exclusion> {
    const url = "http://localhost:8080/api/exclusiones/" + id;
    return this.http.get<Exclusion>(url);
  }

  public crearExclusion(exclusion: Exclusion): Observable<Exclusion> {
    const url = "http://localhost:8080/api/exclusiones";
    return this.http.post(url, exclusion);
  }

  public editarExclusion(exclusion: Exclusion): Observable<Exclusion> {
    const url = "http://localhost:8080/api/exclusiones";
    return this.http.put(url, exclusion);
  }

  public borrarExclusion(id: number): Observable<void> {
    const url = "http://localhost:8080/api/exclusiones/" + id;
    return this.http.delete<void>(url)
  }
}
