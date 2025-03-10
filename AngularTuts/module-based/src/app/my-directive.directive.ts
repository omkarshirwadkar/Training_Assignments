import { Directive } from '@angular/core';

@Directive({
  selector: '[appMyDirective]',
  standalone: false
})
export class MyDirectiveDirective {

  constructor() { }

}
