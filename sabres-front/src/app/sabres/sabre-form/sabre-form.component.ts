import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
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
    private snackBar: MatSnackBar) {
    this.form = this.formBuilder.group({
      tipo: [null],
      dataFabricacao: [null],
      jedi: [null],
      status: [null]
    });
   }

  ngOnInit(): void {
  }

  onSubmit(){
    this.service.save(this.form.value).subscribe(result => {
      this.snackBar.open("Sabre Cadastrado com Sucesso.",'' , {duration: 5000, horizontalPosition: 'center',
        verticalPosition: 'top',
      } );
    });
  }

  onCancel(){

  }


}
