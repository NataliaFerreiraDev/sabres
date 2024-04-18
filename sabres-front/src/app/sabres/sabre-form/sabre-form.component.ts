import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';

import { SabresService } from '../services/sabres.service';

@Component({
  selector: 'app-sabre-form',
  templateUrl: './sabre-form.component.html',
  styleUrls: ['./sabre-form.component.css']
})
export class SabreFormComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private service: SabresService,
    private snackBar: MatSnackBar,
    private location: Location) {
    this.form = this.formBuilder.group({
      tipo: [null],
      dataFabricacao: [null],
      jedi: [null],
      status: [null]
    });
  }

  ngOnInit(): void {
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
