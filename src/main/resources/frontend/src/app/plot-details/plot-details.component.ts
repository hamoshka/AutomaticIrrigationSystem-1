import { Plot } from '../plot';
import { Component, OnInit, Input } from '@angular/core';
import { PlotService } from '../plot.service';
import { PlotListComponent } from '../plot-list/plot-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-plot-details',
  templateUrl: './plot-details.component.html',
  styleUrls: ['./plot-details.component.css']
})
export class PlotDetailsComponent implements OnInit {

  id: number=0 ;
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

  list(){
    this.router.navigate(['plots']);
  }
}
