import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FilmeComponent } from './components/filme/filme.component';
import { DxDataGridModule } from 'devextreme-angular/ui/data-grid';
import { FilmeDataSourceComponent } from './components/filme/filme-data-source/filme-data-source.component';
import { FilmeDataGridComponent } from './components/filme/filme-data-grid/filme-data-grid.component';

@NgModule({
  declarations: [
    AppComponent,
    FilmeComponent,
    FilmeDataSourceComponent,
    FilmeDataGridComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DxDataGridModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
