import { Component } from '@angular/core';
import { ChatServiceService } from '../services/chat-service.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ram',
  imports: [CommonModule],
  templateUrl: './ram.component.html',
  styleUrl: './ram.component.css'
})
export class RamComponent {
  name: string = 'Ram';
  constructor(public cs: ChatServiceService){

  }
  sendMessage(msg: string) {
    this.cs.chatMessage(this.name + ': ' + msg);
  }
}
