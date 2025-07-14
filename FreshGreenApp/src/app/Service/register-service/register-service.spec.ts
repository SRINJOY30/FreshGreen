import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterService } from './register-service';

describe('RegisterService', () => {
  let component: RegisterService;
  let fixture: ComponentFixture<RegisterService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegisterService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterService);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
