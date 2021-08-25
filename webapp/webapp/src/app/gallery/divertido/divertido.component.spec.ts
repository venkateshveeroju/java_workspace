import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DivertidoComponent } from './divertido.component';

describe('DivertidoComponent', () => {
  let component: DivertidoComponent;
  let fixture: ComponentFixture<DivertidoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DivertidoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DivertidoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
