import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Filme } from '../model/filme';
import { Genero } from '../model/genero';

@Injectable({
  providedIn: 'root'
})
export class GeneroService {

  constructor(
    private http: HttpClient
  ) { }

  private readonly API = "http://localhost:8080/api/genero"

  listarTransacoes(): Observable<Genero[]>{
    return this.http.get<Genero[]>(this.API);
  }

  buscarGeneroPorId(id: number):Observable<Genero>{
    return this.http.get<Genero>(`${this.API}/${id}`);
  }

  editarGenero(genero: Genero, id: number): Observable<Genero>{
    return this.http.put<Genero>(`${this.API}/${id}`,Genero);
  }

  adicionarGenero(genero: Genero): Observable<Genero>{
    return this.http.post<Genero>(this.API, Genero)
  }

  deletarGenero(id: number): Observable<Genero>{
    return this.http.delete<Genero>(`${this.API}/${id}`);
  }

}
