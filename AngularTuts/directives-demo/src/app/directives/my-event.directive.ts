import { Directive, HostListener } from '@angular/core';

@Directive({
  selector: '[myEvent]'
})
export class MyEventDirective {
  constructor() { 
    console.log('Event Directive created');
  }
  @HostListener('click')
  abc(): void{
    console.log("You have clicked on this tag");
  }
  @HostListener('mouseenter')
  xyz(): void{
    console.log("You have entered on this tag");
  }
  @HostListener('mouseleave')
  atoz(): void{
    console.log("You have exited on this tag");
  }
}
