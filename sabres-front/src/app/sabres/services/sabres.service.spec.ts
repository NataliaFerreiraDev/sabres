import { TestBed } from '@angular/core/testing';

import { SabresService } from './sabres.service';

describe('SabresService', () => {
  let service: SabresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SabresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
