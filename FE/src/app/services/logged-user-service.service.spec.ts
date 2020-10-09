import { TestBed } from '@angular/core/testing';

import { LoggedUserServiceService } from './logged-user-service.service';

describe('LoggedUserServiceService', () => {
  let service: LoggedUserServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoggedUserServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
