import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sabre } from '../model/sabre';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SabresService {

  private readonly API = 'api/sabres';

  constructor(private httpClient: HttpClient) { }

  save(record: Sabre){
    return this.httpClient.post<Sabre>(this.API, record);
  }

  list(): Observable<Sabre[]>{
    return this.httpClient.get<Sabre[]>(this.API);
  }

}
