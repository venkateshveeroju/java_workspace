import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GriGeneraldisclosuresComponent } from './gri-generaldisclosures.component';

describe('GriGeneraldisclosuresComponent', () => {
  let component: GriGeneraldisclosuresComponent;
  let fixture: ComponentFixture<GriGeneraldisclosuresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GriGeneraldisclosuresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GriGeneraldisclosuresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
