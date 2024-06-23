
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { SabresService } from '../services/sabres.service';
import { Sabre } from '../model/sabre';

@Component({
  selector: 'app-sabre-form',
  templateUrl: './sabre-form.component.html',
  styleUrls: ['./sabre-form.component.css']
})
export class SabreFormComponent implements OnInit {

  currentDate: string = '';

  form = this.formBuilder.group({
    id: [''],
    tipo: ['', [Validators.required]],
    jedi: ['', [Validators.minLength(5), Validators.maxLength(50)]],
    status: ['', [Validators.required]]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
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

  public getErrorMessage(fieldName: string){
    const field = this.form.get(fieldName);

    if(field?.hasError('required')){
      return 'Campo Obrigatório.';
    }

    if(field?.hasError('minlength')){
      const requiredLength = field.errors ? field.errors['minlength']['requiredLength'] : 5;
      return `O tamanho mínimo é de ${requiredLength} caracteres.`;
    }

    if(field?.hasError('maxlength')){
      const requiredLength = field.errors ? field.errors['maxlength']['requiredLength'] : 100;
      return `O tamanho máximo é de ${requiredLength} caracteres.`;
    }

    return 'Campo Inválido';
  }


}
