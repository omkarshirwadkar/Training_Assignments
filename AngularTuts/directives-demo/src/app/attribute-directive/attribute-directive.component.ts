import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-attribute-directive',
  imports: [CommonModule],
  templateUrl: './attribute-directive.component.html',
  styleUrl: './attribute-directive.component.css'
})
export class AttributeDirectiveComponent {
  brdrColor: boolean = true;
  bgColor: boolean = true;
  color: string = 'RED';

  toggleBorder(): void {
    this.brdrColor = !this.brdrColor;
  }
  toggleBg(): void {
    this.bgColor = !this.bgColor;
  }
  setColor( color: string ): void {
    this.color = color;
  }
}
