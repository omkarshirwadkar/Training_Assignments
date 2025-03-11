import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DemoServService {

  constructor() { }
  doSomeTask(): void {
    console.log("Did Some Task......");
    
  }
}
