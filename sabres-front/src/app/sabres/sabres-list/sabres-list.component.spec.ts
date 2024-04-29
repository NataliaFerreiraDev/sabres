import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SabresListComponent } from './sabres-list.component';

describe('SabresListComponent', () => {
  let component: SabresListComponent;
  let fixture: ComponentFixture<SabresListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SabresListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SabresListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
