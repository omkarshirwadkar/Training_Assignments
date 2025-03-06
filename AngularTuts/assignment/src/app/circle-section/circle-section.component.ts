import { Component } from '@angular/core';
import { DiameterPipe } from '../diameter.pipe';
import { PerimeterPipe } from '../perimeter.pipe';
import { AreaPipe } from '../area.pipe';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-circle-section',
  imports: [DiameterPipe, PerimeterPipe, AreaPipe, CommonModule],
  templateUrl: './circle-section.component.html',
  styleUrl: './circle-section.component.css'
})
export class CircleSectionComponent {
  flag: boolean = false;
  toggle(): void {
    if (!this.flag) {
      this.flag = true;
    }
  }
}
