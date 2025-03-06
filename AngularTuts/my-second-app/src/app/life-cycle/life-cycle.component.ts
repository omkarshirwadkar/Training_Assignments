import { CommonModule } from '@angular/common';
import { Component, DoCheck, OnChanges, OnDestroy, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-life-cycle',
  imports: [],
  templateUrl: './life-cycle.component.html',
  styleUrl: './life-cycle.component.css'
})
export class LifeCycleComponent implements OnInit, OnDestroy, OnChanges, DoCheck {
  constructor() {
    console.log("Constructor Called....");
  }
  ngOnInit(): void {
    console.log("ngOnInit Called....");
  }
  ngOnDestroy(): void {
    console.log("ngOnDestroy Called....");
  }
  ngOnChanges(changes: SimpleChanges): void {
    console.log("ngOnChanges Called....");
  }
  ngDoCheck(): void {
    console.log("ngDoCheck Called....");
  }
}
