import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EsgHeaderComponent } from './esg-header.component';

describe('EsgHeaderComponent', () => {
  let component: EsgHeaderComponent;
  let fixture: ComponentFixture<EsgHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EsgHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EsgHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
