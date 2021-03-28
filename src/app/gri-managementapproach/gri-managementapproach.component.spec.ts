import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GriManagementapproachComponent } from './gri-managementapproach.component';

describe('GriManagementapproachComponent', () => {
  let component: GriManagementapproachComponent;
  let fixture: ComponentFixture<GriManagementapproachComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GriManagementapproachComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GriManagementapproachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
