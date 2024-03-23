import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SabresComponent } from './sabres/sabres.component';
import { SabreFormComponent } from './sabre-form/sabre-form.component';

const routes: Routes = [
  {path:'', component: SabresComponent},
  {path:'novo', component: SabreFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SabresRoutingModule { }
