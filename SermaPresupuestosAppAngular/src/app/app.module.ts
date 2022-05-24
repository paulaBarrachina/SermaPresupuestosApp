import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ClienteListComponent } from './entities/cliente/cliente-list/cliente-list.component';
import { PresupuestoListComponent } from './entities/presupuesto/presupuesto-list/presupuesto-list.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { ClienteFormComponent } from './entities/cliente/cliente-form/cliente-form.component';
import { FormsModule } from '@angular/forms';
import { ExclusionListComponent } from './entities/exclusion/exclusion-list/exclusion-list.component';
import { ExclusionFormComponent } from './entities/exclusion/exclusion-form/exclusion-form.component';
import { ArticuloListComponent } from './entities/articulo/articulo-list/articulo-list.component';
import { ArticuloFormComponent } from './entities/articulo/articulo-form/articulo-form.component';
import { ClienteListPagedComponent } from './entities/cliente/cliente-list-paged/cliente-list-paged.component';

@NgModule({
  declarations: [
    AppComponent,
    ClienteListComponent,
    PresupuestoListComponent,
    NavbarComponent,
    ClienteFormComponent,
    ExclusionListComponent,
    ExclusionFormComponent,
    ArticuloListComponent,
    ArticuloFormComponent,
    ClienteListPagedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
