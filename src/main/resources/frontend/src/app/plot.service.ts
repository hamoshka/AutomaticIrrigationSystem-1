import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlotService {

  private baseUrl = 'http://localhost:8080/irrigation/plots';

  constructor(private http: HttpClient) { }
 
  getPlot(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl+"/get"}/${id}`);
  }

  createPlot(plot: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl+"/add"}`, plot);
  }

  updatePlot(plot: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl+"/update"}`, plot);
  }

  

  getPlotsList(): Observable<any> {
    return this.http.get(`${this.baseUrl+"/all"}`);
  }
}
