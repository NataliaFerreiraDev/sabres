import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SabresRoutingModule } from './sabres-routing.module';
import { SabresComponent } from './sabres/sabres.component';
import { SabreFormComponent } from './sabre-form/sabre-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { SabresListComponent } from './sabres-list/sabres-list.component';


@NgModule({
  declarations: [
    SabresComponent,
    SabreFormComponent,
    SabresListComponent
  ],
  imports: [
    CommonModule,
    SabresRoutingModule,
    AppMaterialModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class SabresModule { }
