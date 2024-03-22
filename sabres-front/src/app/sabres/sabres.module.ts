import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SabresRoutingModule } from './sabres-routing.module';
import { SabresComponent } from './sabres/sabres.component';


@NgModule({
  declarations: [
    SabresComponent
  ],
  imports: [
    CommonModule,
    SabresRoutingModule
  ]
})
export class SabresModule { }
