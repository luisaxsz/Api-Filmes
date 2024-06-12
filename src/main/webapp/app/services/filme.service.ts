import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Filme } from '../model/filme';

@Injectable({
  providedIn: 'root'
})
export class FilmeService {

  constructor(
    private http: HttpClient
  ) { }

  private readonly API = "http://localhost:8080/api/genero"

  listarTransacoes(): Observable<Filme[]>{
    return this.http.get<Filme[]>(this.API);
  }

  buscarFilmePorId(id: number):Observable<Filme>{
    return this.http.get<Filme>(`${this.API}/${id}`);
  }

  editarFilme(Filme: Filme, id: number): Observable<Filme>{
    return this.http.put<Filme>(`${this.API}/${id}`,Filme);
  }

  adicionarFilme(Filme: Filme): Observable<Filme>{
    return this.http.post<Filme>(`${this.API}`, Filme)
  }

  deletarFilme(id: number): Observable<Filme>{
    return this.http.delete<Filme>(`${this.API}/${id}`);
  }

}
