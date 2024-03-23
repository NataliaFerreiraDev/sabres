import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SabreFormComponent } from './sabre-form.component';

describe('SabreFormComponent', () => {
  let component: SabreFormComponent;
  let fixture: ComponentFixture<SabreFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SabreFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SabreFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
