import { TestBed } from '@angular/core/testing';

import { SousCategorieService } from './sousCategorie.service';

describe('CategoryService', () => {
  let service: SousCategorieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SousCategorieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
