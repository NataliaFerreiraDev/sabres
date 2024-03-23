import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Sabre } from '../model/sabre';

@Injectable({
  providedIn: 'root'
})
export class SabresService {

  private readonly API = 'api/sabres';

  constructor(private httpClient: HttpClient) { }

  save(record: Sabre){
    return this.httpClient.post<Sabre>(this.API, record);
  }

}
