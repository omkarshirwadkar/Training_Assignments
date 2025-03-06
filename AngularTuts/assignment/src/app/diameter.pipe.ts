import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'diameter'
})
export class DiameterPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): number {
    let val = parseInt(value)
    return val * 2;
  }

}
