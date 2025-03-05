import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-two-way',
  imports: [FormsModule],
  templateUrl: './two-way.component.html',
  styleUrl: './two-way.component.css'
})
export class TwoWayComponent {
  message: string = 'Have a good day';

  display(): void{
    console.log(this.message);
  }
}
