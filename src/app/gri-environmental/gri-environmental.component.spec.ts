import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GriEnvironmentalComponent } from './gri-environmental.component';

describe('GriEnvironmentalComponent', () => {
  let component: GriEnvironmentalComponent;
  let fixture: ComponentFixture<GriEnvironmentalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GriEnvironmentalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GriEnvironmentalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
