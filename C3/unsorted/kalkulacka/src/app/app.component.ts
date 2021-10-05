import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "kalkulacka";

  private inputSNum = "";
  private numbers = [];
  private operationArray = [];
  private result = 0;

  private calcNums(x) {
    this.inputSNum += "" + x;
  }

  private calc(operation) {
    this.numbers.push(parseInt(this.inputSNum));

    switch (operation) {
      case "+":
        this.operationArray.push("+");
        this.inputSNum = "";

        break;

      case "-":
        this.operationArray.push("-");
        this.inputSNum = "";
        break;

      case "/":
        this.operationArray.push("/");
        this.inputSNum = "";
        break;

      case "*":
        this.operationArray.push("*");
        this.inputSNum = "";
        break;
    }
  }

  private show() {
    if (this.numbers.length >= 1) {
      this.numbers.push(parseInt(this.inputSNum));
    }
    for (let x = 0; x < this.numbers.length; x++) {
      switch (this.operationArray[x]) {
        case "+":
          this.result = this.numbers[x];
          this.result = this.result + this.numbers[x + 1];
          this.numbers = [];
          this.operationArray = [];

          break;

        case "-":
          this.result = this.numbers[x];
          this.result = this.result - this.numbers[x + 1];
          this.operationArray = [];
          this.numbers = [];

          break;

        case "/":
          if (this.numbers[x + 1] != 0) {
            this.result = this.numbers[x];
            this.result = this.result / this.numbers[x + 1];
            this.operationArray = [];
            this.numbers = [];
          } else {
            alert("nemuzes delit sebou");
          }
          break;

        case "*":
          this.result = this.numbers[x];
          this.result = this.result * this.numbers[x + 1];
          this.numbers = [];
          this.operationArray = [];
      }
    }
    this.inputSNum = "" + this.result;
  }

  private reset() {
    this.numbers = [];
    this.inputSNum = "";
    this.operationArray = [];
  }
}
