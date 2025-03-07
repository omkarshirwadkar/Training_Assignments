import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ShyamComponent } from "./shyam/shyam.component";
import { RamComponent } from './ram/ram.component';
import { GhanshyamComponent } from "./ghanshyam/ghanshyam.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ShyamComponent, RamComponent, GhanshyamComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'chat-app';
}
