import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SabresService {

  private readonly API = 'api/sabres';

  constructor(private httpClient: HttpClient) { }

}
