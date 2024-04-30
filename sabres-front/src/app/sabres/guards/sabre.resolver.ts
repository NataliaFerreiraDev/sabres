import { Injectable } from '@angular/core';
import {
  Router, Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { SabresService } from '../services/sabres.service';
import { Sabre } from '../model/sabre';

@Injectable({
  providedIn: 'root'
})
export class SabreResolver implements Resolve<Sabre> {

  constructor(private service: SabresService){}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Sabre> {
    if(route.params && route.params['id'] ){
      return this.service.buscaPorId(route.params['id']);
    } 
    return of({id: '', tipo: '', dataFabricacao: '', status: '', jedi: ''});
  }
}
