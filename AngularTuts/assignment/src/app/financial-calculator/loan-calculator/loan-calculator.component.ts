import { Component } from '@angular/core';

@Component({
  selector: 'app-loan-calculator',
  imports: [],
  templateUrl: './loan-calculator.component.html',
  styleUrl: './loan-calculator.component.css'
})
export class LoanCalculatorComponent {
  validateTenure(tenure: string): void{
    let tenureValue = parseInt(tenure);
    if (tenureValue < 1 || tenureValue > this.maxTenure) {
        alert(`Tenure must be between 1 and ${this.maxTenure} years.`);
    }
  }
  maxTenure = 30;
  minAmount = 500000;
  maxAmount = 10000000;
  interestField: string = "";
  amountRange: string = "";
  emi: number = 0.0;

  updateLoanDetails(loanType: string): void {
      if (loanType === "HOME") {
          this.interestField= "9%";
          this.maxTenure = 30;
          this.minAmount = 500000;
          this.maxAmount = 10000000;
          this.amountRange = "Range: 5L - 1Cr";
      } else if (loanType === "CAR") {
          this.interestField = "11%";
          this.maxTenure = 7;
          this.minAmount = 100000;
          this.maxAmount = 1500000;
          this.amountRange = "Range: 1L - 15L";
      } else if (loanType === "PERSONAL") {
          this.interestField = "15%";
          this.maxTenure = 5;
          this.minAmount = 10000;
          this.maxAmount = 500000;
          this.amountRange = "Range: 10k - 5L";
      }
  }
  validateAmount(amountField: string): void {
      let amountValue = parseInt(amountField);
      if (amountValue < this.minAmount || amountValue > this.maxAmount) {
          alert("Amount must be between " + (this.minAmount / 100000) + "L and " + (this.maxAmount / 100000) + "L.");
      }
  }

  calculateEMI(amountValue: string, tenure: string, interest: string): void {
      let amount = parseInt(amountValue);
      let tenureValue = parseInt(tenure);
      if (tenureValue < 1 || tenureValue > this.maxTenure) {
          alert("Please enter a valid tenure before calculating EMI.");
          return;
      }
      if (amount < this.minAmount || amount > this.maxAmount) {
          alert("Please enter a valid amount before calculating EMI.");
          return;
      }
      let interestRate = parseFloat(interest) / (12 * 100);
      let tenureMonths = tenureValue * 12;
      this.emi = (amount * interestRate * Math.pow(1 + interestRate, tenureMonths)) / (Math.pow(1 + interestRate, tenureMonths) - 1);
  }
  getInterest(): string {
    return this.interestField;
  }
  getEMI(): number {
    return this.emi;
  }
}
