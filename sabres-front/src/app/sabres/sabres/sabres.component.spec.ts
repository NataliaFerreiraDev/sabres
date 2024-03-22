import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SabresComponent } from './sabres.component';

describe('SabresComponent', () => {
  let component: SabresComponent;
  let fixture: ComponentFixture<SabresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SabresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SabresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
