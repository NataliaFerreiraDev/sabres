import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { SabreComponent } from '../sabre/sabre.component';
import { NavComponent } from '../nav/nav.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeaderComponent, NavComponent, SabreComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
