import { Component, OnInit } from '@angular/core';
import { Plot } from '../plot';
import { ActivatedRoute, Router } from '@angular/router';
import { PlotService } from '../plot.service';

@Component({
  selector: 'app-update-plot',
  templateUrl: './update-plot.component.html',
  styleUrls: ['./update-plot.component.css']
})
export class UpdatePlotComponent implements OnInit {

  id: number=0;
  plot: Plot = new Plot;

  constructor(private route: ActivatedRoute,private router: Router,
    private plotService: PlotService) { }

  ngOnInit() {
    this.plot = new Plot();

    this.id = this.route.snapshot.params['id'];
    
    this.plotService.getPlot(this.id)
      .subscribe(data => {
        console.log(data)
        this.plot = data;
      }, error => console.log(error));
  }

  updatePlot() {
    this.plotService.updatePlot( this.plot)
      .subscribe(data => {
        console.log(data);
        this.plot = new Plot();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updatePlot();    
  }

  gotoList() {
    this.router.navigate(['/plots']);
  }
}
