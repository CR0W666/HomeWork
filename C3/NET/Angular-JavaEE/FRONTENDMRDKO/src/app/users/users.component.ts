import { Component, OnInit } from '@angular/core';
import {User} from '../User';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  users: User[] = [];
  url = 'api/users/';
  baseUrl: string = 'http://localhost:8080/EducanetWebik/api/users';



  constructor(private http: HttpClient, private router: Router) {
    this.http.get(this.url).subscribe((data: User[]) => {
      this.users = data;
    });
  }

  delete(id: number) {
    this.http.delete(this.url + id).subscribe((data: User) => {
      for(let i = 0; i < this.users.length; i++) {
        let user = this.users[i];
        if(user.id == id) this.users.splice(this.users.indexOf(user), 1);
      }
    });
  }

  details(id: number) {
    this.router.navigate(['/user'], {queryParams: {id}});
  }

  ngOnInit() {
  }

}
