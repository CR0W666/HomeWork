import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'clicker';
  //gameloop handling
  static _out;
  static _seconds;
  static _minutes;
  static _hours;
  static _days;

  //------

  static currency;
  static displayCurrency;
  static suffix;
  static coreE;
  static uOneC;
  static uOneE;
  static uTwoC;
  static uTwoE;
  static uThreeC;
  static uThreeE;
  static uFourC;
  static uFourE;
  static uFiveC;
  static uFiveE;
  static uSixC;
  static uSixE;
  static uSevenC;
  static uSevenE;
  


  ngOnInit(): void {

    this.setup();
    
  }

  setup() {
    let self = AppComponent;
    console.log("setup began");
    self.currency = 0;
    self.suffix = "Bitz";
    self.coreE = 1;
    self._seconds = 0;
    self._minutes = 0;
    self._hours = 0;
    self._days = 0;
    self.uOneC = 0;
    self.uOneE = 0;
    self.uTwoC = 0;
    self.uTwoE = 0;
    self.uThreeC = 0;
    self.uThreeE = 0;
    self.uFourC = 0;
    self.uFourE = 0;
    self.uFiveC = 0;
    self.uFiveE = 0;
    self.uSixC = 0;
    self.uSixE = 0;
    self.uSevenC = 0;
    self.uSevenE = 0;
    console.log("setup done");
    self.start();
  }

  static start() {
    let self = AppComponent;
    setInterval(self.tick, 1000);

  }

  static tick() {
    let self = AppComponent;
    console.log("tick");
    self._seconds++;
    if(self._seconds >= 60) {
      self._seconds = 0;
      self._minutes++;
      if(self._minutes >= 60) {
        self._minutes = 0;
        self._hours++;
        if(self._hours >= 24) {
          self._hours = 0;
          self._days++;
        }
      }
    }
    self.addCurrency("upgrades");
    

  }

  button() {
    AppComponent.addCurrency("core");
  }

  get(what: string) {
    let self = AppComponent;
    switch(what) {
      case "sec":
        return self._seconds;
        break;
      case "min":
        return self._minutes;
        break;
      case "day":
        return self._days;
        break;
      case "hour":
        return self._hours;
        break;
      case "day":
        return self._hours;
        break;
      case "currency":
        return self.currency;
        break;
      case "suffix":
        return self.suffix;
        break;
      default:
        break;
    }
  }

  set(what: string, to) {
    let self = AppComponent;
    switch(what) {
      case "sec":
        self._seconds = to;
        break;
      case "min":
        self._minutes = to;
        break;
      case "day":
        self._days = to;
        break;
      case "hour":
        self._hours = to;
        break;
      case "day":
        self._hours = to;
        break;
      case "currency":
        self.currency = to;
        break;
      case "suffix":
        self.suffix = to;
        break;
      default:
        break;
    }
  }

  static addCurrency(source: string) {

    switch (source) {
      case "core":
        this.currency += this.coreE;
        break;
      case "upgrades":
        this.currency += this.upgradeRevenue();
        break;
      default:
        break;
    }

  }

  static upgradeRevenue() {
    let val = (this.uOneE*this.uOneC) + (this.uTwoE*this.uTwoC) + (this.uThreeE*this.uThreeC) + (this.uFourE*this.uFourC) + (this.uFiveE*this.uFiveC) + (this.uSixE*this.uSixC) + (this.uSevenE*this.uSevenC);
    return val;
  }


}
