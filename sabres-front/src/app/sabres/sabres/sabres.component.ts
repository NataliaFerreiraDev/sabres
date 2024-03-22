import { Component, OnInit } from '@angular/core';
import { SabresService } from '../services/sabres.service';

@Component({
  selector: 'app-sabres',
  templateUrl: './sabres.component.html',
  styleUrls: ['./sabres.component.css']
})
export class SabresComponent implements OnInit {

  constructor(private sabreService: SabresService) { 
    
  }

  ngOnInit(): void {
  }

}
