import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ChatServiceService } from '../services/chat-service.service';

@Component({
  selector: 'app-shyam',
  imports: [CommonModule],
  templateUrl: './shyam.component.html',
  styleUrl: './shyam.component.css'
})
export class ShyamComponent {
name: string = 'Shyam';
  constructor(public cs: ChatServiceService){

  }
  sendMessage(msg: string) {
    this.cs.chatMessage(this.name + ': ' + msg);
  }
}
