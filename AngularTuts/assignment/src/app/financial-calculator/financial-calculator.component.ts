import { Component } from '@angular/core';
import { DepositCalculatorComponent } from './deposit-calculator/deposit-calculator.component';
import { LoanCalculatorComponent } from './loan-calculator/loan-calculator.component';
import { MutualFundCalculatorComponent } from './mutual-fund-calculator/mutual-fund-calculator.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-financial-calculator',
  imports: [DepositCalculatorComponent, LoanCalculatorComponent, MutualFundCalculatorComponent, CommonModule],
  templateUrl: './financial-calculator.component.html',
  styleUrl: './financial-calculator.component.css'
})
export class FinancialCalculatorComponent {
  switchCalculator: number = 0;
  setSwitchCalculator( calculator: number ) {
    this.switchCalculator = calculator;
  }
}
