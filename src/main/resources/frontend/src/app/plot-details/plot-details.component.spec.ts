import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlotDetailsComponent } from './plot-details.component';

describe('plotDetailsComponent', () => {
  let component: PlotDetailsComponent;
  let fixture: ComponentFixture<PlotDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlotDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlotDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
