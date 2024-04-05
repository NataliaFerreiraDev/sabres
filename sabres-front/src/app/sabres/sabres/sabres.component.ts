import { Component, OnInit } from '@angular/core';
import { SabresService } from '../services/sabres.service';
import { Sabre } from '../model/sabre';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-sabres',
  templateUrl: './sabres.component.html',
  styleUrls: ['./sabres.component.css']
})
export class SabresComponent implements OnInit {

  sabres: Observable<Sabre[]>;
  displayedColumns = ['id', 'tipo', 'dataFabricacao', 'status', 'jedi'];

  constructor(private sabreService: SabresService) { 
    this.sabres = this.sabreService.list();
  }

  ngOnInit(): void {
  }

}
