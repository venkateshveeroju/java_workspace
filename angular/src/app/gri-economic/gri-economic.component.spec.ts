import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GriEconomicComponent } from './gri-economic.component';

describe('GriEconomicComponent', () => {
  let component: GriEconomicComponent;
  let fixture: ComponentFixture<GriEconomicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GriEconomicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GriEconomicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
