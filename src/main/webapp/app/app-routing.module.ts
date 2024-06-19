import {NgModule} from '@angular/core';
import {Route, RouterModule} from '@angular/router';

const routes: Route[] = [
  {
    path: 'filme', loadChildren: () => import('./components/filme/filme.routing').then(m => m.FILME_ROUTES)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
