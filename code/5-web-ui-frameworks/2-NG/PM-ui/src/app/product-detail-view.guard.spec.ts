import { TestBed } from '@angular/core/testing';

import { ProductDetailViewGuard } from './product-detail-view.guard';

describe('ProductDetailViewGuard', () => {
  let guard: ProductDetailViewGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ProductDetailViewGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
