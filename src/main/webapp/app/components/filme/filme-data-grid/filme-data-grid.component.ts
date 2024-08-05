import {Component, OnInit} from '@angular/core';
import DevExpress from "devextreme";
import {FilmeService} from "../../../services/filme.service";
import {lastValueFrom} from "rxjs";
import {AppModule} from "../../../app.module";
import DataSource = DevExpress.data.DataSource;
import CustomStore = DevExpress.data.CustomStore;

@Component({
  selector: 'app-filme-data-grid',
  templateUrl: './filme-data-grid.component.html',
  imports: [AppModule],
  standalone: true
})
export class FilmeDataGridComponent implements OnInit {

  dataSource: DataSource;

  constructor(
    private filmeService: FilmeService
  ) {
    this.dataSource = new DataSource({
      store: new CustomStore({
        key: 'id',
        load: () => this.filmeService.listar(),
        insert: (values) => lastValueFrom(this.filmeService.adicionarFilme(values)),
        update: (key, values) => lastValueFrom(this.filmeService.editarFilme(key, values))
      })
    })
  }

  ngOnInit(): void {
  }

}
