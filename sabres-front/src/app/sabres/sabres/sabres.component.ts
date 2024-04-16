import { Component, OnInit } from '@angular/core';
import { SabresService } from '../services/sabres.service';
import { Sabre } from '../model/sabre';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-sabres',
  templateUrl: './sabres.component.html',
  styleUrls: ['./sabres.component.css']
})
export class SabresComponent implements OnInit {

  sabres$: Observable<Sabre[]>;
  displayedColumns = ['id', 'tipo', 'dataFabricacao', 'status', 'jedi', 'actions'];

  constructor(
    private sabreService: SabresService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.sabres$ = this.sabreService.list()
      .pipe(catchError(error => {
        this.onError('Erro ao carregar a lista de Sabres.');
        return of([])
      }));
  }

  onError(errorMsg: String) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  ngOnInit(): void {
  }

  onAdd(){
    console.log("Novo Sabre");
    this.router.navigate(['novo'], {relativeTo: this.route});
  }

}
