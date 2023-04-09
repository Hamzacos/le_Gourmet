import { TestBed } from '@angular/core/testing';

import { LoginuserServiceService } from './loginuser-service.service';

describe('LoginuserServiceService', () => {
  let service: LoginuserServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginuserServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
