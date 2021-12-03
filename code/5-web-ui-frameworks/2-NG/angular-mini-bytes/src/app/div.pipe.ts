import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'division'
})
export class DivPipe implements PipeTransform {

  transform(value: number, ...args: number[]): unknown {
    if (args[0])
      return value / args[0];
    else
      return value / 2
  }

}
