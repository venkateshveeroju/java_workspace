import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrentTopicsComponent } from './current-topics.component';

describe('CurrentTopicsComponent', () => {
  let component: CurrentTopicsComponent;
  let fixture: ComponentFixture<CurrentTopicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CurrentTopicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrentTopicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
