import { Component } from '@angular/core';
import { DemoServService } from '../demo-serv.service';

@Component({
  selector: 'app-demo-comp',
  standalone: false,
  templateUrl: './demo-comp.component.html',
  styleUrl: './demo-comp.component.css'
})
export class DemoCompComponent {
  constructor(private ds: DemoServService){

  }
  methodA(): void {
    this.ds.doSomeTask();
  }
}
