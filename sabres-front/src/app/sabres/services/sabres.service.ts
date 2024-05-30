import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sabre } from '../model/sabre';
import { Observable } from 'rxjs';
import { delay, first, tap } from 'rxjs/operators';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SabresService {

  private readonly API = 'api/sabres';

  constructor(private httpClient: HttpClient) { }

  list(): Observable<Sabre[]>{
    return this.httpClient.get<Sabre[]>(this.API)
    .pipe(
      first(),
      delay(500),
      tap(sabres => console.log(sabres)),
      map(sabres => sabres.sort((a, b) => Number(a.id) - Number(b.id)))
    );
  }

  buscaPorId(id: string){
    return this.httpClient.get<Sabre>(`${this.API}/${id}`)
  }

  save(record: Partial<Sabre>){
    if(record.id){
      return this.update(record);
    }
    return this.create(record);
  }

  private create(record: Partial<Sabre>){
    return this.httpClient.post<Sabre>(this.API, record);
  }

  private update(record: Partial<Sabre>){
    return this.httpClient.put<Sabre>(`${this.API}/${record.id}`, record);
  }

  delete(id: string){
    return this.httpClient.delete<Sabre>(`${this.API}/${id}`);
  }

}
