import { Component } from '@angular/core';

@Component({
  selector: 'app-property-binding',
  imports: [],
  templateUrl: './property-binding.component.html',
  styleUrl: './property-binding.component.css'
})
export class PropertyBindingComponent {
  name: string = 'John';
  married: boolean = true;
  uiType: string = 'text';
  greet(): string {
    return 'Hello, ' + this.name + ' Good Morning';
  }
}
