import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreService } from './store-service';

describe('StoreService', () => {
  let component: StoreService;
  let fixture: ComponentFixture<StoreService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StoreService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StoreService);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
