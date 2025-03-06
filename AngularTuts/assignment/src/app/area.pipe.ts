import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'area'
})
export class AreaPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): number {
    let val = parseInt(value);
    return Math.PI*val*val;
  }

}
