import { PlotService } from '../plot.service';
import { Plot } from '../plot';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-plot',
  templateUrl: './create-plot.component.html',
  styleUrls: ['./create-plot.component.css']
})
export class CreatePlotComponent implements OnInit {

  plot: Plot = new Plot();
  submitted = false;

  constructor(private plotService: PlotService,
    private router: Router) { }

  ngOnInit() {
  }

  newplot(): void {
    this.submitted = false;
    this.plot = new Plot();
  }

  save() {
    this.plotService
    .createPlot(this.plot).subscribe(data => {
      console.log(data)
      this.plot = new Plot();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/plots']);
  }
}
