import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-structural-directive',
  imports: [CommonModule],
  templateUrl: './structural-directive.component.html',
  styleUrl: './structural-directive.component.css'
})
export class StructuralDirectiveComponent {
    flag: boolean = false;
    fruits: string[] = ['Apple', 'Banana', 'Cherry'];
    count: number = 0;

    toggle(): void {
      this.flag = !this.flag;
    }

    addFruit(f: string): void {
      this.fruits.push(f);
    }

    incrCount(): void {
      this.count++;
      if (this.count == 5) {
        this.count = 0;
      }
    }
}
