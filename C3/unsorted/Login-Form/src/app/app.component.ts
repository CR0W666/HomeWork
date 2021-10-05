import { Component } from '@angular/core';
import { ViewEncapsulation} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent {
  title = 'LoginForm';
  private username = "";
  private password = "";
  private readonly correctUsername = "admin";
  private readonly correctPassword = "admin";
  private logged = false;

  buttonClicked() {
    if(this.username === this.correctUsername && this.password === this.correctPassword) {
      this.logged = true;
      alert("Welcome back " + this.correctUsername);
    } else {
      alert("Wrong input credentials.");
    }
  }
  
}
