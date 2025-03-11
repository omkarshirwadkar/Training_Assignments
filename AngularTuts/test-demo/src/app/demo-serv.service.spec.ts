import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoServService } from './demo-serv.service';
import { DemoCompComponent } from './demo-comp/demo-comp.component';

describe('DemoServService', () => {
  let service: DemoServService;
  let fixture: ComponentFixture<DemoCompComponent>;
  let component: DemoCompComponent;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemoServService);

    fixture = TestBed.createComponent(DemoCompComponent);
    component = fixture.componentInstance;
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  it(`should have invoked`, () => {
    spyOn(service, 'doSomeTask');
    component.methodA();
    expect(service.doSomeTask).toHaveBeenCalled();
  })
});
