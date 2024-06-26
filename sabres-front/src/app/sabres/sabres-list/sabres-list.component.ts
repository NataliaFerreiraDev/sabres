import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Sabre } from '../model/sabre';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-sabres-list',
  templateUrl: './sabres-list.component.html',
  styleUrls: ['./sabres-list.component.css']
})
export class SabresListComponent implements OnInit {

  @Input() sabres: Sabre[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() delete = new EventEmitter(false);

  readonly displayedColumns = ['id', 'tipo', 'dataFabricacao', 'status', 'jedi', 'actions'];

  constructor() { }

  ngOnInit(): void {
  }

  onAdd(){
    this.add.emit(true);
  }

  onEdit(sabres: Sabre){
    this.edit.emit(sabres);
  }

  onDelete(sabres: Sabre){
    this.delete.emit(sabres);
  }

}
