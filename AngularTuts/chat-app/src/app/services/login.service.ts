import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { 
    console.log('Login Service constructor called');
  }
  logMessage(msg: string) : void {
    console.log(msg);
  }
}
