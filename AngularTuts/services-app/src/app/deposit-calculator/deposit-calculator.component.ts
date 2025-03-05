import { Component } from '@angular/core';

@Component({
  selector: 'app-deposit-calculator',
  imports: [],
  templateUrl: './deposit-calculator.component.html',
  styleUrl: './deposit-calculator.component.css'
})
export class DepositCalculatorComponent {
  maturityAmount: number = 0;
  getMaturity(): number{
    return this.maturityAmount;
  }
  calculateMaturity(principalValue: string, tenureValue: string): void {
    const principal = parseFloat(principalValue);
    const tenure = parseInt(tenureValue);
    let interestRate = 7 / 100; 
    console.log("Calculating Maturity");
    if (isNaN(principal) || principal <= 0) {
        alert("Please enter a valid principal amount.");
        return;
    }
    if (isNaN(tenure) || tenure < 1 || tenure > 10) {
        alert("Please enter a valid tenure between 1 and 10 years.");
        return;
    }
    this.maturityAmount = principal * Math.pow(1 + interestRate, tenure);
  }
}
