import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'perimeter'
})
export class PerimeterPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): number {
    let val = parseInt(value);
    return 2 * Math.PI * val;
  }

}
