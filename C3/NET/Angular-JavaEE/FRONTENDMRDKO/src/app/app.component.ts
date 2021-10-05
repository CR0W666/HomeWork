import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "./User";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {
  title = 'JavaEE';

  constructor(private http: HttpClient, private router: Router) { }

  user: User;
  logState: boolean = false;

  ngOnInit() {
    this.http.get<User>("/api/auth", {withCredentials: true}).subscribe(
      (data) => {
        this.user = data;
        this.logState = true;
        this.router.navigate(['/user'], {queryParams: {id: data.id}});
      },

      () => {
        console.log("kockapes kam se error, kam se vlez.");
      }
    );
  }

  logout() {
    this.http.delete("/api/auth", {withCredentials: true}).subscribe(
      (data) => {
        this.user = null;
        this.logState = false;
      },

      () => {
        console.log("Neco se dojebkalo.");
      }
    );
  }

}
