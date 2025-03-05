import { Component } from '@angular/core';

@Component({
  selector: 'app-interpolation',
  imports: [],
  templateUrl: './interpolation.component.html',
  styleUrl: './interpolation.component.css'
})
export class InterpolationComponent {
  name: string = 'John';
  age: number = 30;

  getName(): string {
    return this.name;
  }
  getAge(): number {
    return this.age;
  }
}
