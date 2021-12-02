import { TestBed } from '@angular/core/testing';

import { FormStatusGuard } from './form-status.guard';

describe('FormStatusGuard', () => {
  let guard: FormStatusGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(FormStatusGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
