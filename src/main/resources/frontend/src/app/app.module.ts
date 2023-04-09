import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatePlotComponent } from './create-plot/create-plot.component';
import { PlotDetailsComponent } from './plot-details/plot-details.component';
import { PlotListComponent } from './plot-list/plot-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdatePlotComponent } from './update-plot/update-plot.component';
@NgModule({
  declarations: [
    AppComponent,
    CreatePlotComponent,
    PlotDetailsComponent,
    PlotListComponent,
    UpdatePlotComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
