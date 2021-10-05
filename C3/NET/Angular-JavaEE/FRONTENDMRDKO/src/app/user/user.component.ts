import { Component, OnInit } from '@angular/core';
import {User} from '../User';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  users: User;
  url = 'api/users/';
  baseUrl: string = 'http://localhost:8080/EducanetWebik/api/users';

  constructor(private http: HttpClient, private router: Router, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(i => {
      this.http.get(this.url + i.id).subscribe((data: User) => {
        this.users = data;
      });
    });
  }

  ngOnInit() {
  }

}
