import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'excerptTrubka'
})
export class ExcerptTrubkaPipe implements PipeTransform {

  transform(value: string, numChars: number, endChars: string): string {
    let bruh = value;

    if (bruh.length > endChars.length) {
      bruh = bruh.slice(0, numChars - endChars.length);
    }
    
    bruh = bruh.concat(endChars);
    return bruh;
  }

}
