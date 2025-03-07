import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ChatServiceService } from '../services/chat-service.service';

@Component({
  selector: 'app-ghanshyam',
  imports: [CommonModule],
  templateUrl: './ghanshyam.component.html',
  styleUrl: './ghanshyam.component.css'
})
export class GhanshyamComponent {
  name: string = 'Ghanshyam'; 
  constructor(public cs: ChatServiceService){

  }
  sendMessage(msg: string) {
    this.cs.chatMessage(this.name + ': ' + msg);
  }
}
