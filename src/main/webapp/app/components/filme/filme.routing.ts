import {FilmeComponent} from "./filme.component";
import {Routes} from "@angular/router";

export const FILME_ROUTES: Routes = [{
  path: '',
  component: FilmeComponent,
  children: [
    {
      path: 'filme',
      component: FilmeComponent
    },
    {
      path: 'filme/:id'
    }
  ]
}
];

