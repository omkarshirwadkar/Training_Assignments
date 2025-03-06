import { Component } from '@angular/core';
import { SquarePipe } from '../square.pipe';
import { PowerPipe } from '../power.pipe';

@Component({
  selector: 'app-custom-pipes',
  imports: [SquarePipe, PowerPipe],
  templateUrl: './custom-pipes.component.html',
  styleUrl: './custom-pipes.component.css'
})
export class CustomPipesComponent {

}
