import { Component, OnInit } from '@angular/core';
import { DxButtonModule } from 'devextreme-angular';

@Component({
  selector: 'app-filme-data-grid',
  templateUrl: './filme-data-grid.component.html',
  imports: [DxButtonModule],
  standalone: true
})
export class FilmeDataGridComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
