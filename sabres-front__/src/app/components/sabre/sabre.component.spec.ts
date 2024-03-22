import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SabreComponent } from './sabre.component';

describe('SabreComponent', () => {
  let component: SabreComponent;
  let fixture: ComponentFixture<SabreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SabreComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SabreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
