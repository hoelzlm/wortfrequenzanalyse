import { TestBed } from '@angular/core/testing';

import { AnalyseApiService } from './analyse-api.service';

describe('AnalyseApiServiceService', () => {
  let service: AnalyseApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnalyseApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
