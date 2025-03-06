import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CircleSectionComponent } from './circle-section/circle-section.component';
import { CurrencyConverterComponent } from './currency-converter/currency-converter.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CircleSectionComponent, CurrencyConverterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'assignment';
}
