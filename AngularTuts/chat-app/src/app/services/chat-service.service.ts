import { Injectable } from '@angular/core';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class ChatServiceService {
  public messages: string[] = [];

  constructor(private ls: LoginService) { 
    console.log("Chat ServiceService constructor");
  }

  chatMessage(msg: string): void {
    this.messages.push(msg);
    this.ls.logMessage(msg);
  }
}
