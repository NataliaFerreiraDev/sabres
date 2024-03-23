import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SabresRoutingModule } from './sabres-routing.module';
import { SabresComponent } from './sabres/sabres.component';
import { SabreFormComponent } from './sabre-form/sabre-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AppMaterialModule } from '../shared/app-material/app-material.module';


@NgModule({
  declarations: [
    SabresComponent,
    SabreFormComponent
  ],
  imports: [
    CommonModule,
    SabresRoutingModule,
    AppMaterialModule,
    ReactiveFormsModule
  ]
})
export class SabresModule { }
