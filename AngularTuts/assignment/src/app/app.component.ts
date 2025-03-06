import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CircleSectionComponent } from './circle-section/circle-section.component';
import { CurrencyConverterComponent } from './currency-converter/currency-converter.component';
import { FinancialCalculatorComponent } from './financial-calculator/financial-calculator.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CircleSectionComponent, CurrencyConverterComponent, FinancialCalculatorComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'assignment';
}
