import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticuloFormComponent } from './entities/articulo/articulo-form/articulo-form.component';
import { ArticuloListComponent } from './entities/articulo/articulo-list/articulo-list.component';
import { ClienteFormComponent } from './entities/cliente/cliente-form/cliente-form.component';
import { ClienteListPagedComponent } from './entities/cliente/cliente-list-paged/cliente-list-paged.component';
import { ClienteListComponent } from './entities/cliente/cliente-list/cliente-list.component';
import { ExclusionFormComponent } from './entities/exclusion/exclusion-form/exclusion-form.component';
import { ExclusionListComponent } from './entities/exclusion/exclusion-list/exclusion-list.component';
import { PresupuestoListComponent } from './entities/presupuesto/presupuesto-list/presupuesto-list.component';

const routes: Routes = [
  {path: '', component: PresupuestoListComponent, pathMatch: 'full' },
  {path: 'clientes', component: ClienteListComponent, pathMatch: 'full'},
  {path: 'clientes-list-paged', component: ClienteListPagedComponent, pathMatch: 'full'},
  {path: 'clientes/nuevo', component: ClienteFormComponent, pathMatch: 'full'},
  {path: 'clientes/editar/:clienteId', component: ClienteFormComponent, pathMatch: 'full'},
  {path: 'articulos', component: ArticuloListComponent, pathMatch: 'full'},
  {path: 'articulos/nuevo', component: ArticuloFormComponent, pathMatch: 'full'},
  {path: 'articulos/editar/:articuloId', component: ArticuloFormComponent, pathMatch: 'full'},
  {path: 'exclusiones', component: ExclusionListComponent, pathMatch: 'full'},
  {path: 'exclusiones/nueva', component: ExclusionFormComponent, pathMatch: 'full'},
  {path: 'exclusiones/editar/:exclusionId', component: ExclusionFormComponent, pathMatch: 'full'},
  {path: '**', redirectTo:" ", pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
