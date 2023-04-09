import { PlotDetailsComponent } from './plot-details/plot-details.component';
import { CreatePlotComponent } from './create-plot/create-plot.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlotListComponent } from './plot-list/plot-list.component';
import { UpdatePlotComponent } from './update-plot/update-plot.component';

const routes: Routes = [
  { path: '', redirectTo: 'plots', pathMatch: 'full' },
  { path: 'plots', component: PlotListComponent },
  { path: 'add', component: CreatePlotComponent },
  { path: 'update/:id', component: UpdatePlotComponent },
  { path: 'details/:id', component: PlotDetailsComponent },
  { path: '**', component: PlotListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
