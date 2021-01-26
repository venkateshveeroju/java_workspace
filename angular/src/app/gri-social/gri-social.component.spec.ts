import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GriSocialComponent } from './gri-social.component';

describe('GriSocialComponent', () => {
  let component: GriSocialComponent;
  let fixture: ComponentFixture<GriSocialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GriSocialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GriSocialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
