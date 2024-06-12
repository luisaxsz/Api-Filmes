import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-filme',
  template: `
    <main>
      <router-outlet></router-outlet>
    </main>
  `,
  imports: [RouterOutlet],
  standalone: true
})
export class FilmeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
