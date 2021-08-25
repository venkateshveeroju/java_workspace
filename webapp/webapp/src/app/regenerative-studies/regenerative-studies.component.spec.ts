import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegenerativeStudiesComponent } from './regenerative-studies.component';

describe('RegenerativeStudiesComponent', () => {
  let component: RegenerativeStudiesComponent;
  let fixture: ComponentFixture<RegenerativeStudiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegenerativeStudiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegenerativeStudiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
