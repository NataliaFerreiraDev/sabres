import { Routes } from '@angular/router';
import { SabreComponent } from './components/sabre/sabre.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'sabres',
        component: SabreComponent
    }
];
