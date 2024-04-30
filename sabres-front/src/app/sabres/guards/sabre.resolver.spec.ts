import { TestBed } from '@angular/core/testing';

import { SabreResolver } from './sabre.resolver';

describe('SabreResolver', () => {
  let resolver: SabreResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(SabreResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
