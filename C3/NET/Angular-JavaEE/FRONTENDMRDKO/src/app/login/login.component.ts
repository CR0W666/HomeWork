import { Component, OnInit } from '@angular/core';
import {User} from '../User';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  ngOnInit() {
  }

  username: String = '';
  password: String = '';
  url = '/api/auth';
  baseUrl: string = 'http://localhost:8080/EducanetWebik/api/auth';

  constructor(private router: Router, private http: HttpClient, private activatedRoute: ActivatedRoute) { }

  send() {
    const body = {
      username: this.username,
      password: this.password

    };

    this.http.post(this.url, body, {withCredentials: true}).subscribe((data: User) => {
      this.http.get<User>(this.url, {withCredentials: true}).subscribe( (data: User) => {
        console.log(data);
      });
    });

  }



}
