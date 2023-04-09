import { PlotDetailsComponent } from '../plot-details/plot-details.component';
import { Observable } from "rxjs";
import { PlotService } from "./../plot.service";
import { Plot } from "./../plot";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-plot-list",
  templateUrl: "./plot-list.component.html",
  styleUrls: ["./plot-list.component.css"]
})
export class PlotListComponent implements OnInit {
  plots: Observable<Plot[]>;

  constructor(private plotService: PlotService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.plots = this.plotService.getPlotsList();
  }


  plotDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updatePlot(id: number){
    this.router.navigate(['update', id]);
  }
}
