import {FilmeComponent} from "./filme.component";
import {Routes} from "@angular/router";
import {FilmeDataGridComponent} from "./filme-data-grid/filme-data-grid.component";

export const FILME_ROUTES: Routes = [{
  path: '',
  component: FilmeComponent,
  children: [
    {
      path: 'filme',
      component: FilmeDataGridComponent
    },
    {
      path: 'filme/:id'
    }
  ]
}
];

