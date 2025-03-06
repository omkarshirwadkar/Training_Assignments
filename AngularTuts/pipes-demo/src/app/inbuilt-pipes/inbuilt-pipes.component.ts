import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-inbuilt-pipes',
  imports: [CommonModule],
  templateUrl: './inbuilt-pipes.component.html',
  styleUrl: './inbuilt-pipes.component.css'
})
export class InbuiltPipesComponent {
  str: string = 'Angular is a popular JavaScript framework for building web applications.';
  amt: number = 12345;
  dt: Date = new Date();
}
