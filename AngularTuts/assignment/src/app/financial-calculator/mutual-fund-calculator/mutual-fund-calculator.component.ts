import { Component } from '@angular/core';

@Component({
  selector: 'app-mutual-fund-calculator',
  imports: [],
  templateUrl: './mutual-fund-calculator.component.html',
  styleUrl: './mutual-fund-calculator.component.css'
})
export class MutualFundCalculatorComponent {
  total: number = 0;
  getTotal(): number {
    return this.total
  }

  calculateTotal(sip: string, years: string, rate: string): void {
    let sipValue: number = parseFloat(sip);
    let yearsValue: number = parseInt(years);
    let rateValue: number = parseFloat(rate);
    this.total = this.total + (sipValue * yearsValue * rateValue) / 100;
  }
}
