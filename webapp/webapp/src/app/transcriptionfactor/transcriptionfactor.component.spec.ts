import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TranscriptionfactorComponent } from './transcriptionfactor.component';

describe('TranscriptionfactorComponent', () => {
  let component: TranscriptionfactorComponent;
  let fixture: ComponentFixture<TranscriptionfactorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TranscriptionfactorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TranscriptionfactorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
