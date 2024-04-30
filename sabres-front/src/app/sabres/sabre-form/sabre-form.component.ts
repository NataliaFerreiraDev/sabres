
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NonNullableFormBuilder } from '@angular/forms';
import { SabresService } from '../services/sabres.service';
import { Sabre } from '../model/sabre';

@Component({
  selector: 'app-sabre-form',
  templateUrl: './sabre-form.component.html',
  styleUrls: ['./sabre-form.component.css']
})
export class SabreFormComponent implements OnInit {

  form = this.formBuilder.group({
    id: [''],
    tipo: [''],
    dataFabricacao: [''],
    jedi: [''],
    status: ['']
  });

  constructor(private formBuilder: NonNullableFormBuilder,
    private service: SabresService,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute  
  ) {}

  ngOnInit(): void {
    const sabre: Sabre = this.route.snapshot.data['sabre'];
    this.form.setValue({
      id: sabre.id,
      tipo: sabre.tipo,
      dataFabricacao: sabre.dataFabricacao,
      jedi: sabre.jedi,
      status: sabre.status
    }

    )
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe(result => this.onSuccess, error => this.onError());
    this.onCancel();
  }

  onCancel() {
    this.location.back();
  }

  private onSuccess() {
    this.snackBar.open("Sabre Cadastrado com Sucesso.", '', {
      duration: 5000, horizontalPosition: 'center',
      verticalPosition: 'top',
    });
  }

  private onError() {
    this.snackBar.open("Erro ao cadastrar o Sabre.", '', {
      duration: 5000, horizontalPosition: 'center',
      verticalPosition: 'top',
    });
  }


}
