import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {AppModule} from "../../app.module";

@Component({
  selector: 'app-filme',
  template: `
    <main>
      <router-outlet></router-outlet>
    </main>
  `,
  imports: [RouterOutlet, AppModule],
  standalone: true
})
export class FilmeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
