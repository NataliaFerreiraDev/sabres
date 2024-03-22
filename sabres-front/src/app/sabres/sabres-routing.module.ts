import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SabresComponent } from './sabres/sabres.component';

const routes: Routes = [
  {path:'', component: SabresComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SabresRoutingModule { }
