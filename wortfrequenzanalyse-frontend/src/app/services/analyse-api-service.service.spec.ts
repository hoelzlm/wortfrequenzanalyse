import { TestBed } from '@angular/core/testing';

import { AnalyseApiServiceService } from './analyse-api-service.service';

describe('AnalyseApiServiceService', () => {
  let service: AnalyseApiServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnalyseApiServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
