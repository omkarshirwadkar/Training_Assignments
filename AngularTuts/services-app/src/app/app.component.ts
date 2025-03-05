import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DepositCalculatorComponent } from './deposit-calculator/deposit-calculator.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, DepositCalculatorComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'services-app';
}
