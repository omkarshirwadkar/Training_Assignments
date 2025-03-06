import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-currency-converter',
  imports: [CommonModule],
  templateUrl: './currency-converter.component.html',
  styleUrl: './currency-converter.component.css'
})
export class CurrencyConverterComponent {
  amount: number = 0;
  usd : number = 0;
  eur : number = 0;
  jpy: number = 0;
  sar: number = 0;
  aud: number = 0;
  converter(amountValue: string): void{
    this.amount = parseFloat(amountValue);
    this.usd = this.amount * 0.0112;
    this.eur = this.amount * 0.0115;
    this.jpy = this.amount * 1.7;
    this.sar = this.amount * 0.043;
    this.aud = this.amount * 0.016;
  }
}
