import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CircleSectionComponent } from './circle-section.component';

describe('CircleSectionComponent', () => {
  let component: CircleSectionComponent;
  let fixture: ComponentFixture<CircleSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CircleSectionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CircleSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
