import { Component, OnInit } from '@angular/core';
import { SabresService } from '../services/sabres.service';
import { Sabre } from '../model/sabre';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-sabres',
  templateUrl: './sabres.component.html',
  styleUrls: ['./sabres.component.css']
})
export class SabresComponent implements OnInit {

  sabres$!: Observable<Sabre[]>;

  constructor(
    private sabreService: SabresService,
    public dialog: MatDialog,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.loadSabres();
  }

  ngOnInit(): void {
  }

  loadSabres() {
    this.sabres$ = this.sabreService.list()
      .pipe(catchError(error => {
        this.onError('Erro ao carregar a lista de Sabres.');
        return of([]);
      }));
  }

  refresh() {
    this.loadSabres();
  }

  onError(errorMsg: String) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  onAdd(){
    this.router.navigate(['novo'], {relativeTo: this.route});
  }

  onEdit(sabre: Sabre){
    this.router.navigate(['editar', sabre.id], {relativeTo: this.route});
  }

  onDelete(sabre: Sabre) {
    this.sabreService.delete(sabre.id).subscribe(
      () => {
        this.refresh();
        this.snackBar.open('Sabre Deletado com Sucesso.', 'X', {
          duration: 5000,
          horizontalPosition: 'center',
          verticalPosition: 'top'
        });
      },
      error => {
        this.onError('Erro ao deletar o Sabre.');
      }
    );
  }

}
